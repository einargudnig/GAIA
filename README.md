# GAIA
HBV501G


To run this project:

You need to have postgres installed and working on your machine.

You need to clone the repo and/or get the zip file. Open IntelliJ or a IDE that is simillar, we used intelliJ so this may be
slightly different if you have anothe IDE.

Find the Application properties file.
Put your postgres credentials there, username and password. You can see comments in that file on where to put it.

In intelliJ you can build the project, than it is best to run the schema-postgres.sql. This file builds the database according to the schema
in this file, this ensures that you have your database set up in the same way we did.

Next is to run the data-postgres.sql file, that inserts data to the already built database. This data contains some challenges and 4 users.
Here are the users and their password for signing in:  
Username -- Password  
Einar    -- ranie  
Viktor   -- rotkiv  
Ómar     -- ramó  
Páll     -- lláp  
