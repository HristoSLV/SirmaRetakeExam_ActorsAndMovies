# Sirma Academy Retake Exam Project

## This project is made with the following criteria:
### https://drive.google.com/file/d/1GC6nzVvIwpaExviXjNij0Xca-nliSW2O/view

## Based on these requirements, I have come to the following goals in this task:

1. Creating a service for importing data from CSV files.
   - the csv files are located in /resources/taskfiles
3. Storing the data in a database.
4. Creating a REST API for accessing the data.
5. Creating an algorithm for finding the pair of actors who have starred in the most movies together.

## My algorithm works in the following way:

1. The data is collected into a map based on movie IDs and a list of roles.
2. The collection is then iterated over in order to find every pair of actors in each movie.
3. Every discovered pair of actors is then added to another map with a list of every movie they have starred together in.
    - a new map Key is only created the first time a pair is found.
    - subsequent encounters with an existing pair add the movie to the list (value).
4. After the iteration is complete, the function returns the pair of actors with the most movies starred together.
5. The data is returned in the form of a response entity.

## To run the application:

1. The project uses a dockerized database and port 8089 by default. 
2. After starting docker, run the following command:
   - ``docker-compose up``
3. Start the application manually from the IDE.
