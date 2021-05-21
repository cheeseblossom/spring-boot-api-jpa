package playground.cheeseblossom.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "IDX")
  protected Long idx;

  @Column(name = "DEL_YN", length = 1, nullable = false)
  @ColumnDefault("'N'")
  private String delYn;

  @CreatedBy
  @Column(name = "CREATOR_IDX", updatable = false)
  private Long creatorIdx;

  @CreatedDate
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @Column(name = "CREATED_TIME", nullable = false, updatable = false)
  private LocalDateTime createdTime;

  @LastModifiedBy
  @Column(name = "MODIFIER_IDX")
  private Long modifierIdx;

  @LastModifiedDate
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @Column(name = "MODIFIED_TIME", nullable = false)
  private LocalDateTime modifiedTime;

  public void deleteData() {
    this.delYn = "Y";
  }

  public void maintainData() {
    this.delYn = "N";
  }
}