package org.marco.poc.poceurekaconfigserver.serviceserver.service;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Integer id;
    private String username;
    private String firstName;
    private String lastName;

}
