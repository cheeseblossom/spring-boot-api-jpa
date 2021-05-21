package playground.cheeseblossom.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import playground.cheeseblossom.api.domain.Sample;
import playground.cheeseblossom.api.domain.SampleRepository;
import playground.cheeseblossom.api.http.BasicResponse;
import playground.cheeseblossom.api.http.CommonResponse;
import playground.cheeseblossom.api.http.request.sample.SampleRequestDto;
import playground.cheeseblossom.api.http.response.sample.SampleResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SampleService {

  private final SampleRepository sampleRepository;

  @Transactional(readOnly = true)
  public ResponseEntity<BasicResponse> getList() {
    List<SampleResponseDto> result = sampleRepository.findAllByDelYn("N")
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

  @Transactional(rollbackFor = Exception.class)
  public ResponseEntity<BasicResponse> save(SampleRequestDto requestDto) {
    sampleRepository.save(Sample.builder()
            .text(requestDto.getText())
            .build());
    return ResponseEntity.status(HttpStatus.OK)
            .body(new CommonResponse<>("OK"));
  }

  @Transactional(rollbackFor = Exception.class)
  public ResponseEntity<BasicResponse> modify(SampleRequestDto requestDto) {
    Optional<Sample> sample = sampleRepository.findById(requestDto.getIdx());
    if (sample.isEmpty()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .body(new CommonResponse<>("No Data"));
    }
    sampleRepository.save(Sample.builder()
            .idx(sample.get().getIdx())
            .text(requestDto.getText())
            .build());
    return ResponseEntity.status(HttpStatus.OK)
            .body(new CommonResponse<>("OK"));
  }

  @Transactional(rollbackFor = Exception.class)
  public ResponseEntity<BasicResponse> delete(long idx) {
    Optional<Sample> sample = sampleRepository.findById(idx);
    if (sample.isEmpty()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .body(new CommonResponse<>("No Data"));
    }
    sampleRepository.save(Sample.builder()
            .idx(idx)
            .text(sample.get().getText())
            .del("del")
            .build());
    return ResponseEntity.status(HttpStatus.OK)
            .body(new CommonResponse<>("OK"));
  }

  @Transactional(rollbackFor = Exception.class)
  public ResponseEntity<BasicResponse> realDelete(long idx) {
    Optional<Sample> sample = sampleRepository.findById(idx);
    if (sample.isEmpty()) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
              .body(new CommonResponse<>("No Data"));
    }
    sampleRepository.delete(sample.get());
    return ResponseEntity.status(HttpStatus.OK)
            .body(new CommonResponse<>("OK"));
  }
}
