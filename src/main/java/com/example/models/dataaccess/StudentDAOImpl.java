package com.example.models.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.example.models.Student;
import com.example.services.ConnectionProvider;

public class StudentDAOImpl implements StudentDAO {

    Connection con = null;
    PreparedStatement ps = null;

    // connect to database
    public StudentDAOImpl() {
        con = ConnectionProvider.getConnection();
    }

    @Override
    public String enrollStudent(Student student) {

        String result = "Student Enrollment Failed";
        try {
            String query = "INSERT INTO students (email, name, enrollment_year, department_id) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, student.getEmail());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getEnrollmentYear());
            ps.setInt(4, student.getDepartmentId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                result = "Student Enrolled Successfully";
            }
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }

    }
}
