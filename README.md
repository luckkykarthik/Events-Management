# Event Management System

This is an Event Management System built using Spring Boot, MySQL, and Hibernate.

## Tech Stack

- Spring Boot: Framework for building Java applications
- MySQL: Relational database management system
- Hibernate: Object-relational mapping tool for the Java programming language
## Installation

1. Clone the repository:


2. Import the project into Eclipse:
   - Open Eclipse IDE.
   - Go to `File` -> `Import`.
   - Select `Existing Maven Projects`.
   - Browse and select the cloned repository directory.
   - Click `Finish` to import the project.

3. Configure MySQL:
   - Ensure that MySQL server is running.
   - Update database configuration in `src/main/resources/application.properties` with your MySQL username, password, and database name.

4. Run the application:
   - Right-click on the project in Eclipse.
   - Go to `Run As` -> `Spring Boot App`.
   - Alternatively, you can run the application using Maven:
     ```
     mvn spring-boot:run
     ```

5. Access the application at `http://localhost:8080`.
