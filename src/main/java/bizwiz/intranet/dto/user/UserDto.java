package bizwiz.intranet.dto.user;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDto {
    private Integer userID;
    private String userNum;
    private Integer organizationID;
    private Integer teamID;
    private Integer positionID;
    private Integer roleID;
    private String userPw;
    private String name;
    private String email;
    private String privateEmail;
    private String telephone;
    private String phoneNumber;
    private String postcode;
    private String address;
    private LocalDate birthday;
    private String userImg;
    private LocalDate joinDate;
    private String memo;
    private String delYn;
    private String regId;
    private LocalDateTime regDate;
    private String updateId;
    private LocalDateTime updateDate;

}
