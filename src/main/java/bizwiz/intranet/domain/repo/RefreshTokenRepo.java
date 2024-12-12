package bizwiz.intranet.domain.repo;

import bizwiz.intranet.domain.entity.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepo extends JpaRepository<RefreshTokenEntity, Integer>,RefreshTokenRepoDsl {
}
