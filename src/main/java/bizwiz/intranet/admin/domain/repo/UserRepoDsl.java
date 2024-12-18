package bizwiz.intranet.admin.domain.repo;

import bizwiz.intranet.admin.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserRepoDsl {

    List<UserDto> findUserInfo();

    Optional<UserDto> findByUserId(String userID, String userPw);

}
