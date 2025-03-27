package pe.edu.vallegrande.Mockito.service;
import pe.edu.vallegrande.Mockito.repository.*;
import pe.edu.vallegrande.Mockito.model.*;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }
}
