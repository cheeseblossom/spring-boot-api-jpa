package playground.cheeseblossom.api.http.request.sample;

import lombok.Getter;

import javax.validation.constraints.Pattern;

@Getter
public class RemovedSampleRequestDto {

  @Pattern(regexp = "^[0-9]+$", message = "idx는 0이상 숫자이어야 합니다.")
  private String idx;
}
