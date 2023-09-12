package com.perficient.utils;


import com.perficient.user.UserDTO;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class PojoConvertor {

    UserDTO userDTO;

    public UserDTO createUser() {
        userDTO = new UserDTO();
        userDTO.setUsername("Sarker");
        userDTO.setFirstName("Sarker");
        userDTO.setLastName("Jovan");
        userDTO.setPassword("******");
        userDTO.setDateOfBirth(LocalDateTime.of(1991, 3, 26, 5, 30, 30));
        Set<Integer> phoneList = new HashSet<>();
        phoneList.add(440320884);
        phoneList.add(440320882);
        userDTO.setPhoneNumbers(phoneList);
        return userDTO;
    }

    public UserDTO updateUser(int userId) {
        userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setUsername("Omar");
        userDTO.setFirstName("Omar");
        userDTO.setLastName("Sani");
        userDTO.setPassword("******");
        userDTO.setDateOfBirth(LocalDateTime.of(1987, 3, 26, 5, 30, 30));
        Set<Integer> phoneList = new HashSet<>();
        phoneList.add(660320830);
        phoneList.add(660300882);
        userDTO.setPhoneNumbers(phoneList);
        return userDTO;
    }
}
