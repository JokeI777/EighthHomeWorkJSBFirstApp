package com.example.demo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class RequestModel {

    @NotBlank
    @Length(min = 1)
    private String name;

    @NotBlank
    @Length(min = 1)
    private String login;

    @NotBlank
    @Length(min = 3)
    private String password;

    @NotBlank
    @Length(min = 11, max = 11)
    private String phoneNumber;

    public RequestModel(String name, String login, String password, String phoneNumber){
        this.name = name;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
