package com.example.models;

public class Student {
    private String email;
    private String name;
    private int enrollmentYear;
    private int departmentId;

    public Student(String email, String name, int enrollmentYear, int departmentId) {
        this.email = email;
        this.name = name;
        this.enrollmentYear = enrollmentYear;
        this.departmentId = departmentId;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(int enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
