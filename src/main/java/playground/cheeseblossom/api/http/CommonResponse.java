package playground.cheeseblossom.api.http;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CommonResponse<T> extends BasicResponse {

  private int count;
  private T data;

  public CommonResponse(T data) {
    this.data = data;
    this.count = 0;
    if (data instanceof List) {
      this.count = ((List<?>) data).size();
    }
  }
}
