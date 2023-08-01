# Helmes java task

## Author : Markus Männil

This is my Java Task solution

I followed the standard developing structure (frontend <-> controller <-> service <-> repository <-> database)

## Database

I used PostgreSql because I have worked with it before in the university. <br>
Database is named test, which I couldn't change afterwards for some reason. <br> 
For connecting with the database in the file (src/main/resources/) application.properties 
set the database url to path where your postgres server is running. 
I made a new user in postgres named "spring" and gave it permission to alter the database. 

### Tables

#### Sector

In the sector table we have 4 fields:

* **id** (long) - primary key
* **name** (String) - name of the sector
* **level** (int) - for adding the whitespace (for performance, so you don't have to calculate it)
* **parent** (int) - references to the parent sector. if 0 then sector is top level

#### User0

I had to add 0 to user because user is reserved by postgres. <br>
In the user0 table we have 4 fields:

* **id** (long) - primary key
* **name** (String) - name of the user
* **terms** (boolean) - if user had agreed to the terms (should always be true)

#### UserSectors

UserSectors is a many-to-many connection between sector and user0

* **userId** (long) - foreign key -> user0.id
* **sectorId** (long) foreign key -> sector.id

## Sectors to database

For getting sectors into the database I wrote a javascript code which logged
into the console all the sectors in json format. (look into "main/java/resources/static/ ")
Which I later sent to sectorController which processed it.





