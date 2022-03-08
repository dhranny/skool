package com.skool.models;

public class User {

    private enum role{
        STUDENT, LECTURER, ADMIN
    }

    private long id;
    private String firstName;
    private String lastName;
    private byte[] pic;
    private String role;
    private String password;



}
