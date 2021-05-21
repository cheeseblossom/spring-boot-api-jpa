package playground.cheeseblossom.api.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SampleRepository extends JpaRepository<Sample, Long>, SampleRepositoryCustom {
  List<Sample> findAllByDelYn(String delYn);
}
