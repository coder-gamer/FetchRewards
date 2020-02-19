## FetchRewards Version Checker

### Prerequisites
+ Maven (v3.5.2)
+ Java (v1.8)

Note: The project is tested with the above specified versions. It may or may not work with different versions. 

### Building the project
+ Simply run: `mvn package` to build the project and it will create the target directory. 
+ Once built, navigate to the target directory and run the following command: `java -jar VersionComparison-0.0.1-SNAPSHOT.jar` and spring application will start as follows:

![ApplicationStartup](src/main/resources/ApplicationStartup.png)

+ Once the application has started, it can be accessed using the Swagger UI by visiting the following link in any browser: `http://localhost:8080/swagger-ui.html#/` and it will show the endpoint as below:

![SwaggerUI](src/main/resources/SwaggerUI.png)

### Running the unit tests
+ Unit tests can easily be run by the following command: `mvn test` and it should return the output as below:

![UnitTest](src/main/resources/UnitTest.png)

