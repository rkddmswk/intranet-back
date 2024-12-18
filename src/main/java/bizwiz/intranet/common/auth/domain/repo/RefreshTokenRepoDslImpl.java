package bizwiz.intranet.common.auth.domain.repo;

import bizwiz.intranet.common.auth.dto.RefreshTokenDto;
import bizwiz.intranet.common.base.BaseRepo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static bizwiz.intranet.common.auth.domain.entity.QRefreshTokenEntity.refreshTokenEntity;


public class RefreshTokenRepoDslImpl extends BaseRepo implements RefreshTokenRepoDsl {
    public RefreshTokenRepoDslImpl(JPAQueryFactory jpaQueryFactory) {
        super(jpaQueryFactory);
    }

    @Override
    public RefreshTokenDto fineRefreshTokenInfo(String userId) {
        return  jpaQueryFactory.select(
                Projections.fields(
                        RefreshTokenDto.class,
                        refreshTokenEntity.id,
                        refreshTokenEntity.userId,
                        refreshTokenEntity.refreshToken,
                        refreshTokenEntity.expireDate
                ))
                .from(refreshTokenEntity)
                .where(refreshTokenEntity.userId.eq(userId))
                .fetchOne();

    }

    @Override
    public void deleteByUserID(String userID) {
        jpaQueryFactory.delete(refreshTokenEntity)
                .where(refreshTokenEntity.userId.eq(userID))
                .execute();
    }

}
