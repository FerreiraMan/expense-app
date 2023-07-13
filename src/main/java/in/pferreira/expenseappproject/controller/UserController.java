package in.pferreira.expenseappproject.controller;

import in.pferreira.expenseappproject.entity.User;
import in.pferreira.expenseappproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> readUser(@PathVariable Long id) {
        return new ResponseEntity<User>(userService.readUser(id), HttpStatus.OK);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        User newUser = userService.updateUser(user, id);
        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/users")
    public List<User> getAllUsers(Pageable page) {
        return userService.getAllUsers(page).toList();
    }
}
