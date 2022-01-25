package springboot_tuto.tuto.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service   //@Component //bean
public class UserService implements  UserServiceInterface { //comminicate
    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return  userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> OpUser= userRepository.findById(id);
        if(OpUser.isPresent()) return OpUser.get();
        else throw new RuntimeException("Did not find user -id:"+id);
    }

    @Override
    public void saveUser(User user) { //insert & update
        userRepository.save(user);
    }



    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
