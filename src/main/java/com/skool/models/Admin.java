package com.skool.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    String username;



}
