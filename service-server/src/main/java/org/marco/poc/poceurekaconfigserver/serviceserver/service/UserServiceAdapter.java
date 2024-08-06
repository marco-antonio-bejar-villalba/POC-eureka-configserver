package org.marco.poc.poceurekaconfigserver.serviceserver.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.marco.poc.poceurekaconfigserver.serviceserver.dbaccess.JpaUserRepository;
import org.marco.poc.poceurekaconfigserver.serviceserver.dbaccess.User;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceAdapter implements UserServicePort {

  private final JpaUserRepository jpaUserRepository;

  @Override
  public Optional<UserDTO> getUserById(Integer id) {
    return jpaUserRepository.findById(id).map(UserMapper::userToUserDTO);
  }

  @Override
  public UserDTO saveUser(UserDTO userDTO) {
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
    return jpaUserRepository.findAll().stream().map(UserMapper::userToUserDTO).toList();
  }
}
