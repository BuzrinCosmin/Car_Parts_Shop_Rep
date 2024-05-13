# Magazin Piese Auto ( car_parts_shop_rep )

## Meet our team

| Lucian-Ovidiu Marinescu  | ( team leader )     |
|--------------------------|---------------------|
| **Alina Iftode**         | **( full member )** |
| **Buzarin Cosmin**       | **( full member )** |
| **Andrei-Adelin Cazacu** | **( full member )** |
| **George Pletea**        | **( full member )** |

## Object of the project

### Simulate a car parts store, especially the activity of making offers to clients

- #### Create the store database (car_parts_store) - SQL
- #### Create the necessary tables - Java, Hibernate
- #### Populate database - Java
- #### Make offers and persist them - Java
- #### Create user console interface - Java

## Summary

+ #### Instruments
+ #### Programming languages and techniques, data structures
+ #### Schedule
+ #### Assessments


## Instruments

- #### IntelliJ - the main IDE
- #### MySQL Server - the main RDBMS
- #### MySQL Workbench - the IDE for database managing
- #### Git VCS - for deployment
- #### GitHub platform - for storage and publishing
- #### Slack, Zoom - for communication
- #### Google - for searching information

## Programming languages and techniques, data structures

- #### Programming language: Java
- #### Query languages: SQL, HQL
- #### Programming paradigms: OOP, procedural, functional
- #### Framework: Hibernate
- #### Data structures: wrappers, collections, entities

## Schedule

### Day 1

* #### Established project subject and dividing in stages
    * Entities and Hibernate configuration
    * Repositories
    * Populating database
    * Making offers, tests and user console interface
* #### Working on entities
    * Tables:
        * cars (id primary key, brand, model, manufacture_year)
        * car_parts_names (id primary key, name)
        * car_parts (id primary key, oe_number, price, stock)
        * clients (id primary key, name, phone_number)
        * offers (id primary key, amount)
    * Relationships:
        * relationship (clients, offers): oneToMany   
          (one client may receive several offers)
        * relationship (offers, car_parts): manyToMany  
          (one offer may contain several car parts AND one car part may be contained in several offers)
        * relationship (car_parts_names, car_parts): oneToMany    
          (one name may be assumed by several car parts)
        * relationship (car_parts, cars): oneToMany bidirectional   
          (one car is composed by a large amount of car parts BUT one car part is only mounted on one car)

### Day 2

* #### Working on entities and Hibernate configuration

### Day 3

* #### Working on entities and repositories

### Day 4

* #### Working on repositories and populating database

### Day 5

* #### Working on making offers, tests and user console interface

### Day 6

* #### Final examination and presentation

## Assessments

| Lucian-Ovidiu Marinescu  | **( 20% )** |
|--------------------------|-------------|
| **Alina Iftode**         | **( 20% )** |
| **Buzarin Cosmin**       | **( 20% )** |
| **Andrei-Adelin Cazacu** | **( 20% )** |
| **George Pletea**        | **( 20% )** |


