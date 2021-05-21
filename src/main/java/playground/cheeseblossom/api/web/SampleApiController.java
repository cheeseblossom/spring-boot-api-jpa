package playground.cheeseblossom.api.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import playground.cheeseblossom.api.http.BasicResponse;
import playground.cheeseblossom.api.service.SampleService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class SampleApiController {

  private final SampleService sampleService;

  @GetMapping("/list")
  public ResponseEntity<BasicResponse> getList() {
    return sampleService.getList();
  }
}
