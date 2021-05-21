package playground.cheeseblossom.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import playground.cheeseblossom.api.domain.SampleRepository;

@Service
@RequiredArgsConstructor
public class SampleService {

  private final SampleRepository sampleRepository;

}
