package org.marco.poc.poceurekaconfigserver.serviceclient.rest;

import java.util.List;


import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "SERVICE-SERVER")
public interface UserServiceClient {

    @PostMapping("${user.api.url}")
    @Retry(name = "userServiceClient")
    UserDTO saveUser(@RequestBody UserDTO user);

    @PutMapping("${user.api.url}")
    UserDTO updateUser(@RequestBody UserDTO user);

    @DeleteMapping("${user.api.url}/{id}")
    UserDTO deleteUser(@PathVariable Integer id);

    @GetMapping("${user.api.url}/{id}")
    UserDTO getUserById(@PathVariable Integer id);

    @GetMapping(("${user.api.url}"))
    List<UserDTO> getAllUsers();

}
