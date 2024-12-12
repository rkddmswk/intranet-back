package bizwiz.intranet.domain.repo;

import bizwiz.intranet.dto.user.UserDto;

import java.util.List;

public interface UserRepoDsl {

    List<UserDto> findUserInfo();

}
