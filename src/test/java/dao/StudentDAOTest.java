package dao;

import model.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
class StudentDAOTest {
    @Container
    private static final PostgreSQLContainer<?> postgresqlContainer = new PostgreSQLContainer<>("postgres:11.1")
            .withUsername("test")
            .withPassword("test")
            .withDatabaseName("test");

    private static Connection connection;

    @BeforeAll
    static void setup() throws SQLException {
        connection = DriverManager.getConnection(
                postgresqlContainer.getJdbcUrl(),
                postgresqlContainer.getUsername(),
                postgresqlContainer.getPassword()
        );
        try (Statement statement = connection.createStatement()) {
            String createTableSQL = "CREATE TABLE students (\n"
                    + "id INT AUTO_INCREMENT PRIMARY KEY,\n"
                    + "name VARCHAR(255),\n"
                    + "coordinator_id INT\n"
                    + ");";
            statement.execute(createTableSQL);
        }
    }
    @AfterAll
    static void cleanup() throws SQLException {
        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                String dropTableSQL = "DROP TABLE IF EXISTS students";
                statement.execute(dropTableSQL);
            }
            connection.close();
        }
    }
    @Test
    void testInsertStudent() throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        Student student = new Student("Ivan", 1);
        studentDAO.insertStudent(student);

        try (Statement statement = connection.createStatement()) {
            String countSQL = "SELECT COUNT(*) FROM students";
            assertTrue(statement.executeQuery(countSQL).next());
            System.out.println("The record has been created. The database is working...");
        }
    }
}