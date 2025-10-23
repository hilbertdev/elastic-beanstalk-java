package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.example.models.Student;
import com.example.models.dataaccess.StudentDAOImpl;
import com.example.services.ConnectionProvider;

@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentDAOIntegrationTest {

    @Container
    public static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    private static Connection connection;

    @BeforeAll
    static void setUp() throws Exception {
        System.out.println(">>> BeforeAll executing...");
        mysql.start();
        connection = DriverManager.getConnection(
                mysql.getJdbcUrl(), mysql.getUsername(), mysql.getPassword());

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE students (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "email VARCHAR(255), " +
                    "name VARCHAR(255), " +
                    "enrollment_year INT, " +
                    "department_id INT)");
        }

        ConnectionProvider.setConnection(connection);
    }

    @Test
    @Order(1)
    void testEnrollStudent_Integration() {
        var dao = new StudentDAOImpl();
        var student = new Student("test2@example.com", "Jane Doe", 2025, 2);
        String result = dao.enrollStudent(student);
        assertEquals("Student Enrolled Successfully", result);
    }

    @AfterAll
    static void tearDown() throws Exception {
        System.out.println(">>> AfterAll executing...");
        connection.close();
        mysql.stop();
    }
}
