package pe.edu.vallegrande.Mockito.service;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.vallegrande.Mockito.repository.*;
import pe.edu.vallegrande.Mockito.model.*;

class UserServiceTest {

    // Caso 1: Prueba básica de un servicio con un mock de repositorio
    @Test
    void testGetUserById() {
        // Crear el mock de UserRepository
        UserRepository userRepository = mock(UserRepository.class);
        
        // Crear un usuario mock
        User mockUser = new User(1, "Luis Tasayco");
        
        // Configurar el stub para devolver el usuario mock
        when(userRepository.findById(1)).thenReturn(mockUser);
        
        // Crear el servicio y pasarle el repositorio mockeado
        UserService userService = new UserService(userRepository);
        
        // Ejecutar el método de prueba
        User result = userService.getUserById(1);
        
        // Asegurar que el nombre del usuario es el esperado
        assertEquals("John Doe", result.getName(), "El nombre de usuario debe coincidir con el valor esperado.");
    }

    // Caso 2: Simulación de un repositorio con comportamiento falso usando stub
    @Test
    void testGetUserByIdNotFound() {
        // Crear el mock de UserRepository
        UserRepository userRepository = mock(UserRepository.class);
        
        // Configurar el stub para devolver null cuando no se encuentre el usuario
        when(userRepository.findById(0)).thenReturn(null);
        
        // Crear el servicio y pasarle el repositorio mockeado
        UserService userService = new UserService(userRepository);
        
        // Ejecutar el método de prueba
        User result = userService.getUserById(19);
        
        // Asegurarse que el resultado sea null
        assertNull(result, "El usuario no debe existir y debe retornar null.");
    }

    // Caso 3: Verificación de interacción con un mock
    @Test
    void testGetUserByIdInteraction() {
        // Crear el mock de UserRepository
        UserRepository userRepository = mock(UserRepository.class);
        
        // Crear un usuario mock
        User mockUser = new User(1, "Luis Tasayco");
        
        // Configurar el stub para devolver el usuario mock
        when(userRepository.findById(1)).thenReturn(mockUser);
        
        // Crear el servicio y pasarle el repositorio mockeado
        UserService userService = new UserService(userRepository);
        
        // Ejecutar el método de prueba
        userService.getUserById(1);
        
        // Verificar que el repositorio findById fue llamado una vez
        verify(userRepository, times(1)).findById(1);
    }

    // Caso 4: Simulación de excepción
    @Test
    void testGetUserByIdException() {
        // Crear el mock de UserRepository
        UserRepository userRepository = mock(UserRepository.class);
        
        // Configurar el stub para lanzar una excepción
        when(userRepository.findById(9999)).thenThrow(new RuntimeException("Error al obtener el usuario"));
        
        // Crear el servicio y pasarle el repositorio mockeado
        UserService userService = new UserService(userRepository);
        
        // Ejecutar el método de prueba y verificar que se lance la excepción
        assertThrows(RuntimeException.class, () -> {
            userService.getUserById(1);
        });
    }
}
