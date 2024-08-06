package org.marco.poc.poceurekaconfigserver.serviceserver.service;

import java.util.List;
import java.util.Optional;

public interface UserServicePort {
    Optional<UserDTO> getUserById(Integer id);
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    Optional<UserDTO> deleteUser(Integer id);
    List<UserDTO> getAllUsers();
}
