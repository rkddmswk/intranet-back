package bizwiz.intranet.admin.domain.repo;

import bizwiz.intranet.admin.dto.UserDto;
import bizwiz.intranet.common.base.BaseRepo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;
import java.util.Optional;

import static bizwiz.intranet.admin.domain.entity.user.QUserEntity.userEntity;

public class UserRepoDslImpl extends BaseRepo implements UserRepoDsl {

    public UserRepoDslImpl(JPAQueryFactory jpaQueryFactory) {
        super(jpaQueryFactory);
    }

    @Override
    public List<UserDto> findUserInfo() {
        return jpaQueryFactory.select(
                        Projections.fields(
                                UserDto.class,
                                userEntity.userIdx,
                                userEntity.userNum,
                                userEntity.userID,
                                userEntity.companyID,
                                userEntity.organizationID,
                                userEntity.teamID,
                                userEntity.positionID,
                                userEntity.roleID,
                                userEntity.userPw,
                                userEntity.userName,
                                userEntity.email,
                                userEntity.privateEmail,
                                userEntity.telephone,
                                userEntity.phoneNumber,
                                userEntity.postcode,
                                userEntity.address,
                                userEntity.birthday,
                                userEntity.userImg,
                                userEntity.joinDate,
                                userEntity.memo,
                                userEntity.delYn,
                                userEntity.reg_id,
                                userEntity.regDate,
                                userEntity.updateId,
                                userEntity.updateDate
                        )
                ).from(userEntity)
                .fetch();
    }

    @Override
    public Optional<UserDto> findByUserId(String userID, String userPw) {
        return Optional.ofNullable(jpaQueryFactory.select(
                        Projections.fields(UserDto.class,
                                userEntity.userID,
                                userEntity.userPw
                        )

                ).from(userEntity)
                .where(userEntity.userID.eq(userID))
                .fetchOne());
    }
}
