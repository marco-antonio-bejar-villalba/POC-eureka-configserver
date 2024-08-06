package org.marco.poc.poceurekaconfigserver.serviceserver.service;

import org.marco.poc.poceurekaconfigserver.serviceserver.dbaccess.User;

public interface UserMapper {

    static UserDTO userToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }


    static User userDTOToUser(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .build();
    }

}
