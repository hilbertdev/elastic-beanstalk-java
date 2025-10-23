package com.example.services;

import com.example.models.dataaccess.StudentDAO;

public class StudentService {
    private final EmailVerificationProvider emailProvider;
    private final StudentDAO studentDAO;

    public StudentService(EmailVerificationProvider emailProvider, StudentDAO studentDAO) {
        this.emailProvider = emailProvider;
        this.studentDAO = studentDAO;
    }

    public String enrollStudent(String email, String name, int enrollmentYear, int departmentId) {
        if (emailProvider.verifyEmail(email)) {
            var student = new com.example.models.Student(email, name, enrollmentYear, departmentId);
            var result = studentDAO.enrollStudent(student);
            return result;
        }
        return "Invalid Email Address";
    }
}
