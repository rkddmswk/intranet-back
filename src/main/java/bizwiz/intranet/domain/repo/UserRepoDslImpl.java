package bizwiz.intranet.domain.repo;

import bizwiz.intranet.common.base.BaseRepo;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class UserRepoDslImpl extends BaseRepo implements UserRepoDsl {

    public UserRepoDslImpl(JPAQueryFactory jpaQueryFactory) {
        super(jpaQueryFactory);
    }
}
