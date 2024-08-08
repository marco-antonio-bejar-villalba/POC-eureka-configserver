package org.marco.poc.poceurekaconfigserver.serviceclient.rest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceClientFallBack implements UserServiceClient {

    @Override
    public UserDTO saveUser(UserDTO user) {
        return new UserDTO();
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        return new UserDTO();
    }

    @Override
    public UserDTO deleteUser(Integer id) {
        return new UserDTO();
    }

    @Override
    public UserDTO getUserById(Integer id) {
        return new UserDTO();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return new ArrayList<>();
    }
}
