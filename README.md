# Workout App Backend Service

### Description
This app provides a backend service for a workout/fitness app. It provides the database and several endpoints for retrieving and manipulating data in the database.

### Deployment production/local

The live version of this app can be accessed at:
https://workoutservice.herokuapp.com/

To run this application locally:

1. You need to have Java and Java SDK installed on your machine. You can check your system for both with the command :
```
$ java -version
```
If not present, download online.

2. install Maven dependency manager and PostgreSQL are required. To install using homebrew:
```
$ brew install maven
$ brew install postgresql
```
3. Navigate to the directory in which you would like the project to be located in and clone the repository and navigate into the project file:
```
$ git clone https://github.com/TyMazey/workoutService
$ cd workoutService
```
4. Check for an existing PostgresQL user named 'postgres' (exit postgres with '\q'):
```
$ psql
$ \du
```
If no 'postgres' user exists, run the command (from within psql):
```
$ /usr/local/opt/postgres/bin/createuser -s postgres
```
Once created, create a local development database (from within psql, ending semicolon is required):
```
$ CREATE DATABASE workoutService;
```

6. Install dependencies and build the app with:
```
$ mvn install
```
Once this setup is complete, you can run the app locally with the command:
```
$ mvn spring-boot:run
```
And navigate to:
```
$ http://localhost:5000
```

## Running Test

You can run the test suit by running:
```
mvn test
```

If you would like to see the coverage of the test suit run:
```
open target/site/jacoco/index.html
```

### Using the Service

The service has several API endpoints that return JSON data. Complete documentation of these endpoints along with example request and response cycles visit:

https://workout-service-api.docs.stoplight.io/

For a high-level overview of the app read below:

##### Workouts
 - Index: returns all workouts in the system
 - Show: returns one workout in the system
 - Create: allows creation of a new workout in the system
###### Exercises
- Index: returns all exercises in the system
- Show: returns one exercise in the system
- Create: allows creation of a new exercise in the system
###### Tags
- Workout Tags: returns workouts that match the given tags. (Refined Search)
- Exercise Tags: returns exercises that match the given tags. (Refined Search)
###### Ratings
- Create: allows a rating to be submitted for a single workout.

### Schema and TechStack

##### Tech Stack

 - Java
 - SpringBoot
 - Maven
 - JUnit
 - PostgreSQL
 - JPA/Hibernate

##### Schema

This is the final schema of the database and how the tables interact with each other:
 -

### Known Issues

 - Test suit is lacking in integration testing.
 - When running a new build/application the AUTO-INCREMENT tables interfere with the seed data for the first few POST actions.

### Contributors
 - @tymazey - https://github.com/TyMazey
 - @manojpanta - https://github.com/manojpanta

##### Wish to contribute?
- Submit a PR with documentation of the changes and we can review them.
