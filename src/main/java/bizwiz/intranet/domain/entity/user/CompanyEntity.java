package bizwiz.intranet.domain.entity.user;

import bizwiz.intranet.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TB_COMPANY")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "companyID")
    private Integer companyID;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "companyDomain")
    private String companyDomain;

}
