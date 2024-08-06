package org.marco.poc.poceurekaconfigserver.serviceclient.rest;

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
