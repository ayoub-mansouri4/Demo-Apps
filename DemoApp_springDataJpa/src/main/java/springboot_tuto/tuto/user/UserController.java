package springboot_tuto.tuto.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/api")
public class UserController {
    private UserService userService;

    @Autowired //auto inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return  userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable(name = "id") Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User addEmployee(@RequestBody User user) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        //userService.setId(0);
        userService.saveUser(user);
        return user;
    }


    @PutMapping("/users")
    public User updateEmployee(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        User tempEmployee = userService.getUserById(id);
        // throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }
        userService.deleteUser(id);
        return "Deleted employee id - " + id;
    }
}
