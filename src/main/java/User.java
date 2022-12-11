import java.util.Objects;

public class User {

    private final long id;
    private final String name;
    private final String secondName;
    private final String passportId;
    private final String phoneNumber;

    public User(long id, String name, String secondName, String passportId, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.passportId = passportId;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPassportId() {
        return passportId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && name.equals(user.name) && secondName.equals(user.secondName) && passportId.equals(user.passportId) && phoneNumber.equals(user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, secondName, passportId, phoneNumber);
    }
}


