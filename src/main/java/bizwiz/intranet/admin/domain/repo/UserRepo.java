package bizwiz.intranet.admin.domain.repo;

import bizwiz.intranet.admin.domain.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>, UserRepoDsl {
}
