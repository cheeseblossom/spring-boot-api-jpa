package playground.cheeseblossom.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import playground.cheeseblossom.api.domain.SampleRepository;
import playground.cheeseblossom.api.http.BasicResponse;
import playground.cheeseblossom.api.http.CommonResponse;
import playground.cheeseblossom.api.http.response.sample.SampleResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SampleService {

  private final SampleRepository sampleRepository;

  @Transactional(readOnly = true)
  public ResponseEntity<BasicResponse> getList() {
    List<SampleResponseDto> result = sampleRepository.findAll()
            .stream()
            .map(sample -> SampleResponseDto.builder()
                    .idx(sample.getIdx())
                    .text(sample.getText())
                    .createdTime(sample.getCreatedTime())
                    .modifiedTime(sample.getModifiedTime())
                    .build())
            .collect(Collectors.toList());
    return ResponseEntity.status(HttpStatus.OK)
            .body(new CommonResponse<>(result));
  }
}
