# Sirma Academy Retake Exam Project

### This project is made with the following criteria:
### https://drive.google.com/file/d/1GC6nzVvIwpaExviXjNij0Xca-nliSW2O/view

## Based on these requirements, I have come to the following goals in this task:

1. Creating a service for importing data from CSV files.
2. Storing the data in a database.
3. Creating a REST API for accessing the data.
4. Creating an algorithm for finding the pair of actors who have starred in the most movies together.

## My algorithm works in the following way:

1. The data is collected into a map based on movie IDs and a list of roles.
2. The collection is then iterated over in order to find every pair of actors in each movie.
3. Every discovered pair of actors is then added to another map with a list of every movie they have starred together in.
4. After the iteration is complete, the function returns the pair of actors with the most movies starred together.
5. The data is returned in the form of a response entity.
