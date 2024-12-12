package bizwiz.intranet.domain.repo;

import bizwiz.intranet.dto.RefreshTokenDto;

public interface RefreshTokenRepoDsl {

    RefreshTokenDto fineRefreshTokenInfo(String userId);
}
