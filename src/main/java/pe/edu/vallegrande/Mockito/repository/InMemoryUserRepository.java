package pe.edu.vallegrande.Mockito.repository;
import pe.edu.vallegrande.Mockito.model.*;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private Map<Integer, User> userDatabase = new HashMap<>();

    public InMemoryUserRepository() {
        // Pre-poblar algunos usuarios
        userDatabase.put(1, new User(1, "John Doe"));
        userDatabase.put(2, new User(2, "Jane Doe"));
    }

    @Override
    public User findById(int id) {
        return userDatabase.get(id);
    }
}
