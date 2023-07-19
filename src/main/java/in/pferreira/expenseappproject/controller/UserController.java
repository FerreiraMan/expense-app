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

    @GetMapping("/profile")
    public ResponseEntity<User> readUser() {
        return new ResponseEntity<User>(userService.readUser(), HttpStatus.OK);
    }
    @PutMapping("/profile")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User newUser = userService.updateUser(user);
        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/deactivate")
    public ResponseEntity<HttpStatus> deleteUser(){
        userService.deleteUserById();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/users")
    public List<User> getAllUsers(Pageable page) {
        return userService.getAllUsers(page).toList();
    }
}
