
package dao;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.HostConfig;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import model.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
class StudentDAOTest {
    @Container
    private static PostgreSQLContainer<?> postgresqlContainer;

    static {
        DockerImageName postgres = DockerImageName.parse("postgres:13.15");
        postgresqlContainer = new PostgreSQLContainer<>(postgres)
                .withExposedPorts(5439)
                .withUsername("test")
                .withPassword("test")
                .withDatabaseName("test")
                .withReuse(true)
                .withCreateContainerCmdModifier(cmd -> cmd.withHostConfig(
                        new HostConfig().withPortBindings(new PortBinding(Ports.Binding.bindPort(5439), new ExposedPort(5432)))
                ));
    }

    private static Connection connection;

    @BeforeAll
    static void setup() throws SQLException {
        connection = DriverManager.getConnection(
                postgresqlContainer.getJdbcUrl(),
                postgresqlContainer.getUsername(),
                postgresqlContainer.getPassword()
        );
        try (Statement statement = connection.createStatement()) {
            String createTableSQL = """
                                             CREATE TABLE Student (
                                             id SERIAL PRIMARY KEY,
                                             name VARCHAR(255) NOT NULL,
                                             coordinator_id INT REFERENCES Coordinator(id)
                    );""";
            statement.execute(createTableSQL);
        }
    }
    @AfterAll
    static void cleanup() throws SQLException {
        if (connection != null) {
            try (Statement statement = connection.createStatement()) {
                String dropTableSQL =
                        """
                                DROP TABLE IF EXISTS students
                                """;
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
            String countSQL =
                    """
                            SELECT COUNT(*) FROM students
                            """;
            assertTrue(statement.executeQuery(countSQL).next());
            System.out.println("The record has been created. The database is working...");
        }
    }
}
