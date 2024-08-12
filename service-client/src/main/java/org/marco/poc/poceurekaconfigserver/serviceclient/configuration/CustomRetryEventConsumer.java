package org.marco.poc.poceurekaconfigserver.serviceclient.configuration;

import io.github.resilience4j.core.EventConsumer;
import io.github.resilience4j.retry.event.RetryEvent;
import io.github.resilience4j.retry.event.RetryOnErrorEvent;
import io.github.resilience4j.retry.event.RetryOnRetryEvent;
import io.github.resilience4j.retry.event.RetryOnSuccessEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

public class CustomRetryEventConsumer implements EventConsumer<RetryEvent> {

    private static final Logger logger = LoggerFactory.getLogger(CustomRetryEventConsumer.class);

    @Override
    public void consumeEvent(RetryEvent event) {
        if (event instanceof RetryOnErrorEvent) {
            logger.error("Retry on error: {}", event);
        } else if (event instanceof RetryOnRetryEvent) {
            logger.info("Retry on result: {}", event);
        } else if (event instanceof RetryOnSuccessEvent) {
            logger.info("Retry on success: {}", event);
        }
    }
}