# Skool Documentation

## Introduction

Skool is an API that allows user to to create a school management system clients. A school management app in this regard relates to institutions that are divided into departments and students can offer different courses across different departments.

An academic institution can decide at any time to create a mobile app, desktop app, website, etc to manage some of the academic processes in the institution. With skool, the institution does not have to worry about a backend to manage their data, they can easily create a user interface without worrying about how the data will be managed. This is the aim of Skool, to make it easy for academic institutions to create any form of interface on top of the system to manage their processes.

Skool is uses REST endpoints to interact with the user.

The forms of actions that can take place include the following.

- New Student registers
- Student registers for courses
- Lecturer get registered students
- Lecturer update student scores
- Messages are sent to groups
- Student checks their result.
- User login

## Technology Overview

This product was built with java a the primary language. The architecture is domain based in which the domains include:

- Models
- Data Store
- Services
- Rest Interface
    
    ### Database Structure
    
    The system employs a multi-tenant database systems. This allows that each school to have a data source assigned to them. This makes database queries faster.
    
    Hibernate is used as the ORM for the project with Spring-JPA creating a spring overlay on it.
    
    ### Messaging
    
    In each school, department, level, there will always be students and lecturers with similar interests that will want to be able to communicate with each other. The system has in instant messaging systems for students in the same level or students offering the same courses.
    
    The real-time messaging functionality works on top of Kafka with Spring-Kafka as an overlay.
