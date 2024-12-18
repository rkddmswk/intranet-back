package bizwiz.intranet.common.auth.domain.repo;

import bizwiz.intranet.common.auth.domain.entity.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepo extends JpaRepository<RefreshTokenEntity, Integer>,RefreshTokenRepoDsl {
}
