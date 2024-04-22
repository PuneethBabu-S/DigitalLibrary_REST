package com.JBDL.RestDemoLibrary.service.resource;

import com.JBDL.RestDemoLibrary.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email address")
    private String email;
    private String role;
    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

    public User getUser() {
        return User.builder().username(this.username).password(this.password)
                .role((this.role.equals("") ? "user" : this.role)).email(this.email).phoneNumber(this.phoneNumber)
                .build();
    }
}
