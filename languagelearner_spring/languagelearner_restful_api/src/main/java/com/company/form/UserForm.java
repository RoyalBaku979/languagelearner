package com.company.form;

import javax.validation.constraints.NotEmpty;

public class UserForm {

     @NotEmpty(message="name can not be empty")
     String name;

     @NotEmpty(message="surname can not be empty")
     String surname;

     @NotEmpty(message="email can not be empty")
     String email;

     @NotEmpty(message="password can not be empty")
     String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        System.out.println("set email called="+email);
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
