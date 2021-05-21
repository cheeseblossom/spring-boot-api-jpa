package playground.cheeseblossom.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import playground.cheeseblossom.api.entity.AuditorAwareImpl;

@Configuration
@EnableJpaAuditing
public class JpaConfig {

  @Bean
  public AuditorAware<Long> auditorProvider() {
    return new AuditorAwareImpl();
  }
}
