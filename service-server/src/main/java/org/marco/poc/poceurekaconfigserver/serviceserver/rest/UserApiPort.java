package org.marco.poc.poceurekaconfigserver.serviceserver.rest;

import org.marco.poc.poceurekaconfigserver.serviceserver.dbaccess.User;
import org.marco.poc.poceurekaconfigserver.serviceserver.service.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RequestMapping("${user.api.url}")
public interface UserApiPort {

    @PostMapping
    ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user);

    @PutMapping
    ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user);

    @DeleteMapping("/{id}")
    ResponseEntity<UserDTO> deleteUser(@PathVariable Integer id);

    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUserById(@PathVariable Integer id);

    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers();


}
