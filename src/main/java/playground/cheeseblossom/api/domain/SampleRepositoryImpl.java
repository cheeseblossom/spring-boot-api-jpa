package playground.cheeseblossom.api.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SampleRepositoryImpl implements SampleRepositoryCustom {

  private final JPAQueryFactory jpaQueryFactory;

}