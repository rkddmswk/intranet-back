package bizwiz.intranet.common.auth.controller;

import bizwiz.intranet.admin.domain.repo.UserRepo;
import bizwiz.intranet.admin.dto.LoginDto;
import bizwiz.intranet.admin.dto.UserDto;
import bizwiz.intranet.common.auth.domain.repo.RefreshTokenRepo;
import bizwiz.intranet.common.auth.dto.TokenDto;
import bizwiz.intranet.common.auth.service.AuthService;
import bizwiz.intranet.common.base.ResponseResult;
import bizwiz.intranet.common.utils.JwtUtil;
import bizwiz.intranet.common.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/common")
@RestController
public class AuthController {

    private final JwtUtil jwtUtil;

    private final AuthService authService;

    private final UserRepo userRepo;

    private final RefreshTokenRepo refreshTokenRepo;

    @PostMapping("/login")
    public ResponseEntity<ResponseResult> login(
            @RequestBody LoginDto loginDto
    ) {
        TokenDto tokenDto = authService.loginUser(loginDto);

        return ResponseUtils.ConvertResponse(tokenDto);

    }
}
