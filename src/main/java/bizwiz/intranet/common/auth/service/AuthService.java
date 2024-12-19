package bizwiz.intranet.common.auth.service;

import bizwiz.intranet.admin.domain.repo.UserRepo;
import bizwiz.intranet.admin.dto.LoginDto;
import bizwiz.intranet.admin.dto.UserDto;
import bizwiz.intranet.common.auth.domain.entity.RefreshTokenEntity;
import bizwiz.intranet.common.auth.domain.repo.RefreshTokenRepo;
import bizwiz.intranet.common.auth.dto.TokenDto;
import bizwiz.intranet.common.crypto.EncryptionService;
import bizwiz.intranet.common.exception.custom.UserIdPasswordMismatchException;
import bizwiz.intranet.common.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

    private final EncryptionService encryptionService;

    private final RefreshTokenRepo refreshTokenRepo;

    private final UserRepo userRepo;


    @Transactional
    public TokenDto loginUser(LoginDto dto) {

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(dto.getUserID());

        if (!matcher.find()) {
            throw new UserIdPasswordMismatchException("이메일 형식이 올바르지 않습니다..");
        }

        String userId = dto.getUserID().substring(0, dto.getUserID().indexOf("@"));
        String userPw = dto.getUserPw();

        Optional<UserDto> userDto = userRepo.findByUserId(userId, dto.getUserPw());
        userDto.orElseThrow(() ->
                new UserIdPasswordMismatchException("존재하지 않는 아이디 입니다")
                );


        boolean isMatch = passwordEncoder.matches(userPw, userDto.get().getUserPw());
        if (!isMatch) {
            throw new UserIdPasswordMismatchException("비밀번호가 일치하지 않습니다.");
        }

        refreshTokenRepo.deleteByUserID(userId);

        String accessToken = jwtUtil.generateAccessToken(userId);
        String refreshToken = jwtUtil.generateRefreshToken(userId);
        LocalDateTime refreshTokenExpire = LocalDateTime.now().plusDays(7);

        RefreshTokenEntity refreshTokenEntity = RefreshTokenEntity.builder()
                .userId(userId)
                .refreshToken(refreshToken)
                .expireDate(refreshTokenExpire)
                .build();

        refreshTokenRepo.save(refreshTokenEntity);

        TokenDto tokenDto = new TokenDto();
        tokenDto.setAccessToken(accessToken);
        tokenDto.setRefreshToken(refreshToken);

        return tokenDto;


    }

}
