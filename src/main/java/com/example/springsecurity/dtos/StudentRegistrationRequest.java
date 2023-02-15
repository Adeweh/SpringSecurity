package com.example.springsecurity.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class StudentRegistrationRequest {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String passWord;

}
