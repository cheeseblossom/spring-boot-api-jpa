package playground.cheeseblossom.api.entity;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Long> {

  @Override
  public Optional<Long> getCurrentAuditor() {
    Long id = 0L;
    return Optional.ofNullable(id);
  }
}