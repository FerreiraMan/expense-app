package in.pferreira.expenseappproject.service;

import in.pferreira.expenseappproject.entity.User;
import in.pferreira.expenseappproject.entity.UserModel;
import in.pferreira.expenseappproject.exceptions.ItemAlreadyExistsException;
import in.pferreira.expenseappproject.exceptions.ResourceNotFoundException;
import in.pferreira.expenseappproject.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserModel user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ItemAlreadyExistsException("Email is already used:"+user.getEmail());
        }
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        return userRepository.save(newUser);
    }
    @Override
    public User readUser(Long id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User "+id+" not found."));
    }
    @Override
    public User updateUser(User user, Long id) throws ResourceNotFoundException {
        User existingUser = readUser(id);
        existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
        existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
        existingUser.setPassword(user.getPassword() != null ? user.getPassword() : existingUser.getPassword());
        existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());
        return userRepository.save(existingUser);
    }
}

