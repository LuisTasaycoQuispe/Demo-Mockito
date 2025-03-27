package pe.edu.vallegrande.Mockito.repository;
import pe.edu.vallegrande.Mockito.model.User;
public interface UserRepository {
    User findById(int id);
}
