package org.marco.poc.poceurekaconfigserver.serviceclient.rest;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.common.circuitbreaker.configuration.CommonCircuitBreakerConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("${user.client.api.url}")
public class ClientController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);
    private final UserServiceClient userServiceClient;
    private final CircuitBreakerRegistry circuitBreakerRegistry;
    private final CommonCircuitBreakerConfigurationProperties commonCircuitBreakerConfigurationProperties;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
        return ResponseEntity.ok(userServiceClient.saveUser(user));
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user) {
        return ResponseEntity.ok(userServiceClient.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userServiceClient.deleteUser(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userServiceClient.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        log.error("CircuitBreakerConfigurationProperties: {}",
                circuitBreakerRegistry.getAllCircuitBreakers().stream().map(circuitBreaker -> circuitBreaker.getName()).collect(Collectors.joining()));
        log.error("CircuitBreakerRegistry: {}", circuitBreakerRegistry
                .circuitBreaker("SERVICE-SERVER").getMetrics().getNumberOfFailedCalls());
        log.error("CircuitBreakerRegistry: {}", circuitBreakerRegistry
                .circuitBreaker("UserServiceClientgetAllUsers").getMetrics().getNumberOfFailedCalls());

        return ResponseEntity.ok(userServiceClient.getAllUsers());
    }

}
