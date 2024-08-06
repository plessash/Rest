
Task:

Make REST Service using JDBC and Servlet;
CRUD service that has the following features:
Course
Identifier Title List of students (ManyToMany)

Student
Identifier Name Coordinator Course list (ManyToMany)

Coordinator
Identifier Name Student list (OneToMany)

Not permitted to use Spring, Hibernate;
Must be implemented not lazy communications OneToMany, ManyToMany;
Servlet must accept and return DTO (do not return Entity);
Must be unit tests, use Mockito and Junit;
Use integration testing with testcontainers to test the DB-based repository (DAO) (make sure that the connection in the tests is to the testcontainer, not to the main SUBD);
The coating of tests should be more than 80%;
Postgres DBMS;
Lombok and SonarLint are recommended;
Don’t forget about interfaces, javadki, logins;
For the injection of password and logon use the piercing;
The delivery of Z through sending in personal message in Telegram link to pull request from GitHub.
