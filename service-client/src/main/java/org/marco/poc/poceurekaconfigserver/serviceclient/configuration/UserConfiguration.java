package org.marco.poc.poceurekaconfigserver.serviceclient.configuration;

import feign.Retryer;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class UserConfiguration {

  private final RetryRegistry retryRegistry;

//    @Bean
//    public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
//        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
//                .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build())
//                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
//                .build());
//    }

//  @Bean
//  public Retryer retryer() {
//    // For some reason you have to define the Retryer bean here, otherwise it will not work.
//    // Nontheless, the configuration is taken from application.yml.
//    // Recap, this is a different configuration, this is for the feign client, the other one is for
//    // the resilience4j retry.
//    return new Retryer.Default(100, 1000, 4);
//  }

  @Bean
  public Retry registerRetryEventConsumer() {
    Retry retry = retryRegistry.retry("userServiceClient");
    retry.getEventPublisher().onEvent(new CustomRetryEventConsumer());
    log.warn("Retry configuration: {}", retry);
    return retry;
  }
}
