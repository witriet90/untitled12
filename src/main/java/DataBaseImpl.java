import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBaseImpl implements DataBase {

    private Map<Long, User> allUsers = new HashMap<>();
    private long userlastId = 0;

    @Override
    public User createUser(User user) {
        userlastId++;
        User userToSave = copyUser(userlastId, user);
        allUsers.put(userlastId, userToSave);
        return userToSave;
    }

    @Override
    public User updateUser(long id, User user) {
        User previousUser = allUsers.replace(id, user);
        if (previousUser != null) {
            return user;
        } else {
            throw new DataBaseException("Такого пользователя не существует");
        }
    }

    @Override
    public User deleteUser(long id) {
        User removedUser = allUsers.remove(id);
        if (removedUser != null) {
            return removedUser;
        }
        throw new DataBaseException("Такого пользователя не существует");
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (Map.Entry<Long, User> entry : allUsers.entrySet()) {
            users.add(entry.getValue());
        }
        return users;
    }

    @Override
    public User getUserById(long id) {
        User user = allUsers.get(id);
        if (user != null) {
            return user;
        } else {
            throw new DataBaseException("Пользователь не найден");
        }
    }

    private User copyUser(long newId, User user) {
        if (user != null) {
            return new User(newId, user.getName(), user.getSecondName(), user.getPassportId(), user.getPhoneNumber());
        } else {
            throw new DataBaseException();
        }

    }
}

