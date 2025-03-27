package pe.edu.vallegrande.Mockito.service;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.vallegrande.Mockito.repository.*;
import pe.edu.vallegrande.Mockito.model.*;

class UserServiceTest {

    @Test
    void testGetUserById() {
        UserRepository userRepository = mock(UserRepository.class);

        User mockUser = new User(1, "John Doe");
        when(userRepository.findById(1)).thenReturn(mockUser);

        UserService userService = new UserService(userRepository);

        User result = userService.getUserById(1);
        assertEquals("John Doe", result.getName());
    }
}
