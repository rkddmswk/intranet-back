package bizwiz.intranet.domain.entity.user;

import bizwiz.intranet.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "TB_USER")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @Column(name = "userNum", length = 8, unique = true)
    private String userNum;

    @Column(name = "userName")
    private String userName;

    @Column(name = "companyID")
    private Integer companyID;

    @Column(name = "organizationID")
    private Integer organizationID;

    @Column(name = "teamID")
    private Integer teamID;

    @Column(name = "positionID")
    private Integer positionID;

    @Column(name = "roleID")
    private Integer roleID;

    @Column(name = "userPw", length = 200)
    private String userPw;

    @Column(name = "name", length = 255)
    private String name;

    @Column(name = "email", length = 255, unique = true)
    private String email;

    @Column(name = "privateEmail", length = 255)
    private String privateEmail;

    @Column(name = "telephone", length = 255)
    private String telephone;

    @Column(name = "phoneNumber", length = 15)
    private String phoneNumber;

    @Column(name = "postcode", length = 15)
    private String postcode;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "userImg", length = 255)
    private String userImg;

    @Column(name = "joinDate")
    private LocalDate joinDate;

    @Column(name = "memo", length = 255)
    private String memo;

}
