package bizwiz.intranet.admin.service.user;


import bizwiz.intranet.admin.domain.entity.user.UserEntity;
import bizwiz.intranet.admin.domain.repo.UserRepo;
import bizwiz.intranet.admin.dto.UserDto;
import bizwiz.intranet.common.crypto.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final EncryptionService encryptionService;

    private final PasswordEncoder passwordEncoder;

    private final UserRepo userRepo;

    public void setUserTest(List<UserDto> dto) {

        List<UserEntity> list = new ArrayList<>();

        try {
            for (UserDto data : dto) {

                String userPw = passwordEncoder.encode(data.getUserPw());
                String email = encryptionService.encrypt(data.getEmail());

                UserEntity userEntity = UserEntity.builder()
                        .userIdx(data.getUserIdx())
                        .userID(data.getUserID())
                        .userNum(data.getUserNum())
                        .companyID(data.getCompanyID())
                        .userID(data.getUserID())
                        .organizationID(data.getOrganizationID())
                        .teamID(data.getTeamID())
                        .positionID(data.getPositionID())
                        .roleID(data.getRoleID())
                        .userPw(userPw)
                        .userName(data.getUserName())
                        .email(email)
                        .privateEmail(data.getPrivateEmail())
                        .telephone(data.getTelephone())
                        .phoneNumber(data.getPhoneNumber())
                        .postcode(data.getPostcode())
                        .address(data.getAddress())
                        .birthday(data.getBirthday())
                        .userImg(data.getUserImg())
                        .joinDate(data.getJoinDate())
                        .memo(data.getMemo())
                        .build();

                list.add(userEntity);
            }

            userRepo.saveAll(list);

        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }

    }

    public List<UserDto> getUserInfo() {
        return userRepo.findUserInfo();
    }

}
