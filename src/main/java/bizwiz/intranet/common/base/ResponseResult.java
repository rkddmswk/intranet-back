package bizwiz.intranet.common.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Data
@Builder
@AllArgsConstructor
@SuppressWarnings("serial")
public class ResponseResult implements Serializable {

    private static final long serialVersionUID = -1206151647868602861L;

    protected ResponseResult(){}

    @Builder.Default
    String resultCode = "1000";
    @Builder.Default
    String msg = "OK";

    @Builder.Default
    Object data;

    @Builder.Default
    TimeZone timeZone = TimeZone.getDefault();

    @Builder.Default
    LocalDateTime timeStamp = LocalDateTime.now();

    @Builder.Default
    String languageCode = "KR";

}
