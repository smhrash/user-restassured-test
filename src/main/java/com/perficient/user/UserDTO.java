package com.perficient.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class UserDTO {

    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private LocalDateTime dateOfBirth;
    private Set<Integer> phoneNumbers;
}
