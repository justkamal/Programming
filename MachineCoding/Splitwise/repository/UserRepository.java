package Splitwise.repository;

import Splitwise.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private static Map<String, User> userDb;
    private static Integer sequenceId;

    public UserRepository() {
        userDb = new HashMap<>();
        sequenceId = 0;
    }

    public User findUserById(String userId) {
        return userDb.get(userId);
    }

    public List<User> fetchAllUsers() {
        return userDb.values().stream().toList();
    }

    public void createUser(User user) {
        userDb.put(user.getUserId(), user);
        ++sequenceId;
    }

    public Integer getNewId(){
        return sequenceId;
    }
}
