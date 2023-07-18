package in.pferreira.expenseappproject.service;

import in.pferreira.expenseappproject.entity.User;
import in.pferreira.expenseappproject.entity.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User createUser(UserModel user);
    User readUser(Long id);
    User updateUser(User user, Long  id);
    void deleteUserById(Long id);
    Page<User> getAllUsers(Pageable page);
    User getLoggedInUser();
}
