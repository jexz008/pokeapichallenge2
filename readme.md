# Pokeapaichallenge
***

Table of Contents
1. [General Info](#general-info)
2. [Technologies](#technologies)
3. [Installation requirements](#installation-requirements)
4. [Installation](#installation)
5. [Testing](#testing)


### General Info
***
The project consists of consuming the information by means of a rest API type service
from the https://pokeapi.co/api/v2/ API to be transformed and generate web services
using the methods:
1 abilities
2 base_experience
3 held_items
4 id
5 name
6 location_area_encounters
Each request is saved in the request database, exactly the data:
1 ip de origin
2 fecha de request
3 método que se ejecuta


## Technologies
***
A list of technologies used within the project:
* [Java]: Version 1.8 
* [Spring Boot]: Version 2.7.6
* [MongoDB]: Version 4.0.10


## Installation requirements
***
Clone the project from https://github.com/jexz008/pokeapichallenge.git
In the properties file indicate the connection endpoint to the MongoDB database
The path file is: \pokeapichallenge\src\main\resources\application.properties
The property to modify is spring.data.mongodb.uri
Example: spring.data.mongodb.uri=mongodb://localhost:27017/pokeapichallenge


## Installation
***
To execute and see the operation of the project, through the IDE, right click to give clean and build,
then the dependencies of the Maven repository will be downloaded. Once done, right click again to select the Run option. 
The information will be displayed in the console like:
----------------------< com.jci:pokeapichallenge >----------------------
Building pokeapichallenge 0.0.1-SNAPSHOT
--------------------------------[ jar ]---------------------------------

--- exec-maven-plugin:3.0.0:exec (default-cli) @ pokeapichallenge ---

2022-12-21 23:10:47.511  INFO 30948 --- [localhost:27017] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:1, serverValue:282}] to localhost:27017
2022-12-21 23:10:47.512  INFO 30948 --- [localhost:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=localhost:27017, type=STANDALONE, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=7, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=32156100}
2022-12-21 23:10:48.312  INFO 30948 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-12-21 23:10:48.327  INFO 30948 --- [           main] c.j.p.PokeapichallengeApplication        : Started PokeapichallengeApplication in 3.019 seconds (JVM running for 3.452)


## Testing
***
Using the SoapUi program
Click on the SOAP option and enter in Initial WSDL 
http://localhost:8080/api/v2/pokemon.wsdl
The methods in which you have to enter the name of the pokemon will be shown