package bizwiz.intranet.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RefreshTokenDto {

    private int id;

    private String userId;

    private String refreshToken;

    private LocalDateTime expireDate;

}
