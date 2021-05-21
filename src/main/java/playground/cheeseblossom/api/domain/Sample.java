package playground.cheeseblossom.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import playground.cheeseblossom.api.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "T_SAMPLE")
@DynamicInsert
@DynamicUpdate
public class Sample extends BaseEntity {

  @Column(name = "text", length = 10, nullable = false)
  private String text;

  @Builder
  public Sample(long idx, String text) {
    super.idx = idx;
    this.text = text;
    super.maintainData();
  }
}
