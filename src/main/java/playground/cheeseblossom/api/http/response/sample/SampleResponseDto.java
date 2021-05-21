package playground.cheeseblossom.api.http.response.sample;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class SampleResponseDto {

  private long idx;
  private String text;
  private String createdTime;
  private String modifiedTime;

  @Builder
  public SampleResponseDto(long idx, String text, LocalDateTime createdTime, LocalDateTime modifiedTime) {
    this.idx = idx;
    this.text = text;
    this.createdTime = createdTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    this.modifiedTime = modifiedTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
  }
}
