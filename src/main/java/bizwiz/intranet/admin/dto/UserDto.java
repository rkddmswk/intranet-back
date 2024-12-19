package bizwiz.intranet.admin.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDto {
    private Integer userIdx;
    private String userNum;
    private String userID;
    private Integer companyID;
    private Integer organizationID;
    private Integer teamID;
    private Integer positionID;
    private Integer roleID;
    private String userPw;
    private String userName;
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
    private String phoneVisibleYn;
    private String emailVisibleYn;
    private String userNumVisibleYn;
    private String joinDateVisibleYn;
    private String birthdayVisibleYn;
    private String addressVisibleYn;
    private String memoVisibleYn;
}
