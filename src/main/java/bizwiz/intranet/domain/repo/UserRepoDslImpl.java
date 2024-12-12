package bizwiz.intranet.domain.repo;

import bizwiz.intranet.common.base.BaseRepo;
import bizwiz.intranet.dto.user.UserDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import java.util.List;

import static bizwiz.intranet.domain.entity.user.QUserEntity.userEntity;

public class UserRepoDslImpl extends BaseRepo implements UserRepoDsl {

    public UserRepoDslImpl(JPAQueryFactory jpaQueryFactory) {
        super(jpaQueryFactory);
    }

    @Override
    public List<UserDto> findUserInfo() {
        return jpaQueryFactory.select(
                        Projections.fields(
                                UserDto.class,
                                userEntity.userID,
                                userEntity.userNum,
                                userEntity.organizationID,
                                userEntity.teamID,
                                userEntity.positionID,
                                userEntity.roleID,
                                userEntity.userPw,
                                userEntity.name,
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
}
