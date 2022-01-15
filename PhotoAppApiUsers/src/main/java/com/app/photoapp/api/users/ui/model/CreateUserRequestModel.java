package com.app.photoapp.api.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 10,message = "Must be atleast 3 char.")
    private String firstName;

    @NotNull(message = "lastname cannot be null")
    @Size(min = 3, max = 10,message = "Must be atleast 3 char.")
    private String lastName;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8,max = 16,message = "Must be atleast 8 char.")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Please Enter valid email.")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
