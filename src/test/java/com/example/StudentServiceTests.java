package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;
import com.example.models.Student;
import com.example.models.dataaccess.StudentDAO;
import com.example.services.EmailVerificationProvider;
import com.example.services.StudentService;

public class StudentServiceTests {

    @Test
    public void testEnrollStudent_MockDAO() {
        // Arrange
        StudentDAO mockDAO = Mockito.mock(StudentDAO.class);

        Mockito.when(mockDAO.enrollStudent(Mockito.any(Student.class)))
                .thenReturn("Student Enrolled Successfully");
        
        

        EmailVerificationProvider mockProvider = mock(EmailVerificationProvider.class);
        when(mockProvider.verifyEmail("student@example.com")).thenReturn(true);

        var sut = new StudentService(mockProvider, mockDAO);

        // Act

        String result = sut.enrollStudent("student@example.com", "John Doe", 2025, 1);

        // Assert
        assertEquals("Student Enrolled Successfully", result);
        Mockito.verify(mockDAO).enrollStudent(Mockito.any(Student.class));
            // Verify interaction with mock
        verify(mockProvider, times(1));
    }
}
