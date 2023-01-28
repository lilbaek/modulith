package com.lilbaek.feature.user.model;

import com.lilbaek.framework.ValidEmail;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class UserDto {

    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 8)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto that = (UserDto) o;
        return Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}