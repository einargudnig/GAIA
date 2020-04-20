# GAIA
HBV501G


## Update
We did changes to this project. Now it works as a RESTful API. 
https://github.com/einargudnig/GAIA-2.0 This repo has the android app that connects to this API.
More info can be found there.
If you want to test the API we recommend to use Postman.


To run this project:

You need to have postgres installed and working on your machine.

You need to clone the repo and/or get the zip file. Open IntelliJ or a IDE that is simillar, we used intelliJ so this may be
slightly different if you have anothe IDE.

It is important to have maven and a pom.xml file for the dependcies we used int this project.  
IntellJ imports and updates dependencies automaticly for the user, at least it did for us, so we recommend using intelliJ.

Find the application.properties file.  
Put your postgres credentials there, username and password. You can see comments in that file on where to put it.

In intelliJ you can build the project, than it is best to run the schema-postgres.sql. This file builds the database according to the schema
in this file, this ensures that you have your database set up in the same way we did.

Next is to run the data-postgres.sql file, that inserts data to the already built database. This data contains some challenges and 4 users.
Here are the users and their password for signing in:  
| Username    | Password    |
| ----------- | ----------- |
| Einar       | ranie       |
| Páll        | llap        |
| Ómar        | ramo        |
| Viktor      | rotkiv      |
