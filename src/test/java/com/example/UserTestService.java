package com.example;

import org.junit.jupiter.api.Test;

import com.example.models.User;
import com.example.services.UserService;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {

    @Test
    void testAddUser() {
        UserService service = new UserService();
        User user = new User("Alice");
        service.addUser(user);
        assertEquals(1, service.getAllUsers().size());
    }
}



