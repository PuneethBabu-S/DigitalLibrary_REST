package com.JBDL.RestDemoLibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String UserId;
    private String username;
    private String password;
    private String role;
    private String email;
    private String phoneNumber;
}
