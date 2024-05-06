# springboot-movie-app


Minimal [Spring Boot](http://projects.spring.io/spring-boot/),[Thymeleaf](https://www.thymeleaf.org/) Movie app.

## Requirements

For building and running the application you need:

- [JDK 16](https://www.oracle.com/java/technologies/javase-jdk16-downloads.html)
- [Maven 3.8.1](https://maven.apache.org)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Spring Data Jpa](https://spring.io/projects/spring-data-jpa)
- [Spring Security 5](https://spring.io/projects/spring-security)
- [MySql](https://www.mysql.com/)
- [Bootstrap](https://getbootstrap.com/)

## ScreenShots
![Menu](https://github.com/hsnhutt/springboot-movie/blob/master/screenshots/1.png "Menu")
[![Actor List](https://github.com/hsnhutt/springboot-movie/blob/master/screenshots/2.png "Actor List")](https://github.com/hsnhutt/springboot-movie/blob/master/screenshots/2.png "Actor List")
[![Add Actor](https://github.com/hsnhutt/springboot-movie/blob/master/screenshots/3.png "Add Actor")](https://github.com/hsnhutt/springboot-movie/blob/master/screenshots/3.png "Add Actor")
[![Add Movie](https://github.com/hsnhutt/springboot-movie/blob/master/screenshots/4.png "Add Movie")](https://github.com/hsnhutt/springboot-movie/blob/master/screenshots/4.png "Add Movie")

## Login Info
**For User**(can only see actors and movies, can not edit.):<br />
Username = user<br />
Password = password

**For Admin**:<br />
Username = admin<br />
Password = admin

## MySql Info

    spring.datasource.url=jdbc:mysql://localhost:3306/movie
    spring.datasource.username=root
    spring.datasource.password=Sql12345
    spring.jpa.show-sql=true`
	server.port = 8181
[![MySql Table](https://github.com/hsnhutt/springboot-movie/blob/master/screenshots/5.png "MySql Table")](https://github.com/hsnhutt/springboot-movie/blob/master/screenshots/5.png "MySql Table")

### Running Examples
- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open IntelliJ 
   - File -> Open ->  Navigate to the folder where you unzipped the zip
   - Select the right project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application
- You are all Set

