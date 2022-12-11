import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataBaseImplTest {

    private DataBaseImpl dataBaseImpl;

    @Before
    public void setUp() {
        dataBaseImpl = new DataBaseImpl();
    }

    @Test
    public void checkCreateUser() {
        User user = new User(0, "name", "second", "passport", "12345");
        User createdUser = dataBaseImpl.createUser(user);

        User savedUser = dataBaseImpl.getUserById(createdUser.getId());

        Assert.assertEquals(createdUser, savedUser);
    }

    @Test
    public void checkExistingUserUpdate() {
        User user = new User(0, "name", "second", "passport", "12345");
        User createdUser = dataBaseImpl.createUser(user);

        User userUpdate = new User(createdUser.getId(), "name22", "second", "passport", "122344");
        User resultOfUpdate = dataBaseImpl.updateUser(createdUser.getId(), userUpdate);

        Assert.assertEquals(resultOfUpdate, userUpdate);
    }

    @Test(expected = DataBaseException.class)
    public void checkUpdatingExistNotUserUpdateDb() {
        User user = new User(12345, "name", "second", "passport", "12345");
        dataBaseImpl.updateUser(user.getId(), user);
    }

    @Test(expected = DataBaseException.class)
    public void checkDeleteUser() {
        User user = new User(0, "name", "second", "passport", "12345");
        User createdUser = dataBaseImpl.createUser(user);

        dataBaseImpl.deleteUser(createdUser.getId());
        dataBaseImpl.getUserById(createdUser.getId());
    }

    @Test()
    public void checkNotDeleteUser() {
        User user = new User(0, "name", "second", "passport", "12345");
        User createdUser = dataBaseImpl.createUser(user);

        User deleteUser = dataBaseImpl.deleteUser(createdUser.getId());

        Assert.assertEquals(deleteUser, createdUser);
    }

    @Test(expected = DataBaseException.class)
    public void checkDeleteNotExistUser() {
        User user = new User(222222, "name", "second", "passport", "12345");
        dataBaseImpl.deleteUser(user.getId());
    }

    @Test
    public void checkGetAllUsers() {
        User user = new User(0, "name", "second", "passport", "12345");
        dataBaseImpl.createUser(user);
        dataBaseImpl.getAllUsers();
    }

    @Test
    public void checkGetUserById() {
        User user = new User(0, "name", "second", "passport", "12345");
        User createdUser = dataBaseImpl.createUser(user);

        User getUserById = dataBaseImpl.getUserById(createdUser.getId());

        Assert.assertEquals(createdUser, getUserById);
    }

    @Test(expected = DataBaseException.class)
    public void checkNotGetUserById() {
        User user = new User(4566, "name", "second", "passport", "12345");
        dataBaseImpl.getUserById(user.getId());

    }

}