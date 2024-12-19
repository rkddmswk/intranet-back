package bizwiz.intranet.common.auth;

import bizwiz.intranet.common.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.soap.SOAPArrayType;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.naming.AuthenticationException;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("AuthInterceptor ::: ->");

        String accessToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        checkAccessToken(accessToken);

        return true;
    }

    private void checkAccessToken(String accessToken) throws Exception {
        log.info("토큰 체크");
        accessToken = accessToken.replace("Bearer ", "");
        String userId = jwtUtil.extractUserId(accessToken);


        if (!jwtUtil.isTokenValid(accessToken, userId)) {
            throw new AuthenticationException("토큰 만료. 다시 로그인해 주세요.");
        }
    }

/*    private boolean isOptionsMethod(HttpServletRequest request) {
        return "OPTIONS".equalsIgnoreCase(request.getMethod());
    }*/

}


