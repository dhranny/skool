CREATE TABLE if not exists public.DATASOURCECONFIG (
   id bigint PRIMARY KEY,
   driverclassname VARCHAR(255),
   url VARCHAR(255),
   name VARCHAR(255),
   username VARCHAR(255),
   password VARCHAR(255),
   initialize BOOLEAN
);