# HrTrack Application 
Deploy this sample application to Pivotal Web Services:
TBD

## Running hrtrack locally
HrTrack is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/).

```
cd spring-hrtrack
./mvnw package
mvnw spring-boot:run
```

If changes are made, you may have to run:
```
mvnw spring-javaformat:apply
```
You can then access hrtrack here: http://localhost:8080/


## Database 

In its default configuration, HrTrack uses an in-memory database (H2) which
gets populated at startup with data. The h2 console is automatically exposed at `http://localhost:8080/h2-console`
and it is possible to inspect the content of the database using the `jdbc:h2:mem:testdb` url.
 
MySql implementation is a work in progress but will go like this: 
A similar setup can be done for MySql in case a persistent database configuration is desired.
Note that whenever the database type is changed, the app needs to be run with a different profile: `spring.profiles.active=mysql` for MySql.

You could start MySql locally with the installer or with docker:

```
docker run -e MYSQL_USER=hrtrack -e MYSQL_PASSWORD=hrtrack -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=hrtrack -p 3306:3306 mysql:5.7.8
```

### Prerequisites
The following items should be installed in your system:
* Java 8 or newer.
* Maven 3 
* Optionally, your preferred IDE 
  * Eclipse with the m2e plugin.
  * [Spring Tools Suite](https://spring.io/tools) (STS)
  * IntelliJ IDEA
  * [VS Code](https://code.visualstudio.com)

