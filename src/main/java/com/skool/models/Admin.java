package com.skool.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Admin extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    String username;



}
