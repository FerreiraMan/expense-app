package in.pferreira.expenseappproject.service;

import in.pferreira.expenseappproject.entity.User;
import in.pferreira.expenseappproject.entity.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User createUser(UserModel user);
    User readUser();
    User updateUser(User user);
    void deleteUserById();
    Page<User> getAllUsers(Pageable page);
    User getLoggedInUser();
}
