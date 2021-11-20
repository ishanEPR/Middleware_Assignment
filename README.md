# SCS3203-Middleware Architecture Mini Project

## 1. How to build and/or deploy the API

### step 1
 This is an instruction to build & run the Dockerfile of this project.

 Before building the docker image run:
  ```bash
  mvn package
  ```
   
 Then, build the image with:
 ```bash
  docker build -f src/main/docker/Dockerfile.jvm -t reshmika1997/quarkus-demo .
  ```

 Then run the container using:
 ```bash
  docker run -i --rm -p 8080:8080 reshmika1997/quarkus-demo
  ```

### step 2
I used mysql Database in this project.So I wanted to use Mysql Docker image for deployment process.
These are instructions to build run the mysql docker image.


Download mysql docker image by using: 
 ```bash
  docker pull mysql
  ```
After that, then set environment variable for mysql container. Run the mysql image.

### step 3
I have two docker images.Then I created docker-compose.yml.
( I used docker compose file for parallely run these docker images.)
  

## 2. How to run test suite
Test suites are written using JUnit.
Firstly run the project.
Select a test case and then run using the IDE.(I suggest IntelliJ IDE)


## 3. How to run a CURL/WGET command to test the APIs once deployed

This is the instruction to test the APIs using command line.

Open the cmd.
* get the pet details.
curl http://localhost:8080/data/pet/getDetails


* add a pet
curl -d '{"petName":"Pettappu","petAge":2,"petType":"Parrot","petColor":"Green"}' -H 'Content-Type: application/json' http://localhost:8080/data/pet





















