package playground.cheeseblossom.api.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import playground.cheeseblossom.api.http.BasicResponse;
import playground.cheeseblossom.api.http.CommonResponse;
import playground.cheeseblossom.api.http.request.sample.SampleRequestDto;
import playground.cheeseblossom.api.service.SampleService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class SampleApiController {

  private final SampleService sampleService;

  @GetMapping("/list")
  public ResponseEntity<BasicResponse> getList() {
    return sampleService.getList();
  }

  @PostMapping("/save")
  public ResponseEntity<BasicResponse> save(@Valid @RequestBody SampleRequestDto requestDto, BindingResult br) {
    if (br.hasErrors()) {
      List<ObjectError> list = br.getAllErrors();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .body(new CommonResponse<>(list));
    }
    return sampleService.save(requestDto);
  }

  @PutMapping("/change")
  public ResponseEntity<BasicResponse> modify(@Valid @RequestBody SampleRequestDto requestDto, BindingResult br) {
    if (br.hasErrors()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .body(new CommonResponse<>(br.getAllErrors()));
    }
    return sampleService.modify(requestDto);
  }
}
