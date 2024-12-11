package bizwiz.intranet.common.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Slf4j
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Column(name = "delYn")
    protected String delYn;

    @CreatedBy
    @Column(name = "regId", updatable = false)
    protected String reg_id = "system";

    @CreatedDate()
    @Column(name = "regDate", updatable = false)
    protected LocalDateTime regDate;

    @LastModifiedBy
    @Column(name = "updateId")
    protected String updateId = "system";

    @LastModifiedDate
    @Column(name = "updateDate")
    protected LocalDateTime updateDate;

    // API Auditing 생성, 수정 시간 자동화
    @PrePersist
    public void prePersist(){
        this.regDate = new Timestamp(System.currentTimeMillis()).toLocalDateTime();
        this.updateDate = this.regDate;
        this.delYn = "N";
    }

    @PreUpdate
    public void PreUpdate(){
        this.updateDate = new Timestamp(System.currentTimeMillis()).toLocalDateTime();
        this.delYn = "N";
    }

}
