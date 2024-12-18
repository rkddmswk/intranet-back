package bizwiz.intranet.common.auth.domain.repo;

import bizwiz.intranet.common.auth.dto.RefreshTokenDto;

public interface RefreshTokenRepoDsl {

    RefreshTokenDto fineRefreshTokenInfo(String userId);

    void deleteByUserID(String userID);
}
