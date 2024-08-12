package org.marco.poc.poceurekaconfigserver.serviceserver.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.marco.poc.poceurekaconfigserver.serviceserver.dbaccess.JpaUserRepository;
import org.marco.poc.poceurekaconfigserver.serviceserver.dbaccess.User;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceAdapter implements UserServicePort {

  private final JpaUserRepository jpaUserRepository;
  private final ThreadLocalRandom random = ThreadLocalRandom.current();

  @Override
  public Optional<UserDTO> getUserById(Integer id) {
    return jpaUserRepository.findById(id).map(UserMapper::userToUserDTO);
  }

  @Override
  public UserDTO saveUser(UserDTO userDTO) {
    int i = random.nextInt(0, 2);
    log.error("Random number for delay: {}, key {}", i, userDTO.getUsername());
    if(i == 0) {
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    return UserMapper.userToUserDTO(jpaUserRepository.save(UserMapper.userDTOToUser(userDTO)));
  }

  @Override
  public UserDTO updateUser(UserDTO userDTO) {
    return UserMapper.userToUserDTO(jpaUserRepository.save(UserMapper.userDTOToUser(userDTO)));
  }

  @Override
  public Optional<UserDTO> deleteUser(Integer id) {
    Optional<User> user = jpaUserRepository.findById(id);
    if (user.isPresent()) {
      jpaUserRepository.delete(user.get());
      return user.map(UserMapper::userToUserDTO);
    } else {
      return Optional.empty();
    }
  }

  @Override
  public List<UserDTO> getAllUsers() {
    int i = random.nextInt(0, 2);
    log.error("Random number: {}", i);
    if(i == 1) {
      throw new RuntimeException("Random exception");
    }
    return jpaUserRepository.findAll().stream().map(UserMapper::userToUserDTO).toList();
  }
}
