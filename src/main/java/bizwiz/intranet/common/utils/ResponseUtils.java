package bizwiz.intranet.common.utils;

import bizwiz.intranet.common.base.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class ResponseUtils {

    public static ResponseEntity<ResponseResult> ConvertResponse() {
        return ResponseEntity.ok(ResponseResult.builder().build());
    }

    public static ResponseEntity<ResponseResult> ConvertResponse(Object data) {

        return ResponseEntity.ok(
                ResponseResult.builder().data(data).build());
    }

    public static ResponseEntity<ResponseResult> ConvertResponse(Object data, long total) {

        return ResponseEntity.ok(
                ResponseResult.builder().data(data).build());
    }


}
