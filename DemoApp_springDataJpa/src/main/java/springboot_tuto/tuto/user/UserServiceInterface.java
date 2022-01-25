package springboot_tuto.tuto.user;

import java.util.*;

public interface UserServiceInterface {
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public void saveUser(User user);
    public void deleteUser(Long id);
}
