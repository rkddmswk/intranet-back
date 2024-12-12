package bizwiz.intranet.service.user;


import bizwiz.intranet.domain.entity.user.UserEntity;
import bizwiz.intranet.domain.repo.UserRepo;
import bizwiz.intranet.dto.user.UserDto;
import bizwiz.intranet.service.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final EncryptionService encryptionService;

    private final UserRepo userRepo;

    public void setUserTest(List<UserDto> dto) {

        List<UserEntity> list = new ArrayList<>();

        try {
            for (UserDto data : dto) {

                String userPw = encryptionService.encrypt(data.getUserPw());
                String email = encryptionService.encrypt(data.getEmail());

                UserEntity userEntity = UserEntity.builder()
                        .userID(data.getUserID())
                        .userNum(data.getUserNum())
                        .name(data.getName())
                        .organizationID(data.getOrganizationID())
                        .teamID(data.getTeamID())
                        .positionID(data.getPositionID())
                        .roleID(data.getRoleID())
                        .userPw(userPw)
                        .name(data.getName())
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
