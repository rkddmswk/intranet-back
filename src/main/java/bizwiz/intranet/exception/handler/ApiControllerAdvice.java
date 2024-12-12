package bizwiz.intranet.exception.handler;

import bizwiz.intranet.common.base.ResponseResult;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringWriter;

@RestController
@Slf4j
public class ApiControllerAdvice {
    // Controller 계층 exception 만 처리. Service 에서 throw e 하기
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseResult> handleException(Exception e) {
        e.printStackTrace();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        e.printStackTrace(pw);
        return ResponseEntity.ok(
                ResponseResult.builder().msg(e.getMessage()).data(e.getMessage()).resultCode("9999").build());
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ResponseResult> handleExpiredJwtExceptions(ExpiredJwtException e) {
        e.printStackTrace();
        return ResponseEntity.ok(
                ResponseResult.builder().msg(e.getMessage()).data("엑세스 토큰이 만료되었습니다.").resultCode("401").build());
    }

}
