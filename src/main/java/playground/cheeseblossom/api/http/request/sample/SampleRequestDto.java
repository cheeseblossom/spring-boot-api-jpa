package playground.cheeseblossom.api.http.request.sample;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
public class SampleRequestDto {

  private long idx;

  @NotEmpty(message = "text는 값이 있어야 합니다.")
  @Length(min = 1, max = 10, message = "text는 10자까지 입력 가능합니다.")
  private String text;

  @Builder
  public SampleRequestDto(long idx, String text) {
    this.idx = idx;
    this.text = text;
  }
}
