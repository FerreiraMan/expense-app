package in.pferreira.expenseappproject.service;

import in.pferreira.expenseappproject.entity.User;
import in.pferreira.expenseappproject.entity.UserModel;

public interface UserService {
    User createUser(UserModel user);
    User readUser(Long id);
}
