package org.marco.poc.poceurekaconfigserver.serviceserver.rest;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.marco.poc.poceurekaconfigserver.serviceserver.service.UserDTO;
import org.marco.poc.poceurekaconfigserver.serviceserver.service.UserServicePort;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RefreshScope
public class UserApiAdapter implements UserApiPort {

  private final UserServicePort userServicePort;

  @Override
  public ResponseEntity<UserDTO> saveUser(UserDTO user) {
    UserDTO userDTO = userServicePort.saveUser(user);
    return ResponseEntity.ok(userDTO);
  }

  @Override
  public ResponseEntity<UserDTO> updateUser(UserDTO user) {
    UserDTO userDTO = userServicePort.updateUser(user);
    return ResponseEntity.ok(userDTO);
  }

  @Override
  public ResponseEntity<UserDTO> deleteUser(Integer id) {
    Optional<UserDTO> userDTO = userServicePort.deleteUser(id);
    return userDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Override
  public ResponseEntity<UserDTO> getUserById(Integer id) {
    return userServicePort
        .getUserById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @Override
  public ResponseEntity<List<UserDTO>> getAllUsers() {
    return ResponseEntity.ok(userServicePort.getAllUsers());
  }
}
