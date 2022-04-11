package pl.mateusz.zadanie20;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private List<User> userList;

    public UserRepository(List<User> userList) {
        this.userList = userList;
        userList.add(0, new User("Kamil", "Kowalski", 24));
        userList.add(1, new User("Mateusz", "Solecki", 29));
        userList.add(2, new User("Monika", "Nowak", 32));
    }

    public List<User> getAll() {
        return userList;
    }

    public void add(User user) {
        userList.add(user);
    }
}
