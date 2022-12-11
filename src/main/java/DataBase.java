import java.util.List;

public interface DataBase {

    User createUser(User user);

    User updateUser(long id, User user);

    User deleteUser(long id);

    List<User> getAllUsers();

    User getUserById(long id);
}


