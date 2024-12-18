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
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;

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
        String userPw = dto.getUserPw();

        Optional<UserDto> userDto = userRepo.findByUserId(dto.getUserID(), dto.getUserPw());
        userDto.orElseThrow(() ->
                new UserIdPasswordMismatchException("존재하지 않는 아이디 입니다")
                );


        boolean isMatch = passwordEncoder.matches(userPw, userDto.get().getUserPw());
        if (!isMatch) {
            throw new UserIdPasswordMismatchException("비밀번호가 일치하지 않습니다.");
        }

        refreshTokenRepo.deleteByUserID(dto.getUserID());

        String accessToken = jwtUtil.generateAccessToken(dto.getUserID());
        String refreshToken = jwtUtil.generateRefreshToken(dto.getUserID());
        LocalDateTime refreshTokenExpire = LocalDateTime.now().plusDays(7);

        RefreshTokenEntity refreshTokenEntity = RefreshTokenEntity.builder()
                .userId(dto.getUserID())
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
