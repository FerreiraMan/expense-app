package in.pferreira.expenseappproject.service;

import in.pferreira.expenseappproject.entity.User;
import in.pferreira.expenseappproject.entity.UserModel;
import in.pferreira.expenseappproject.exceptions.ItemAlreadyExistsException;
import in.pferreira.expenseappproject.exceptions.ResourceNotFoundException;
import in.pferreira.expenseappproject.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public User createUser(UserModel user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new ItemAlreadyExistsException("Email is already used:"+user.getEmail());
        }
        User newUser = new User();
        BeanUtils.copyProperties(user, newUser);
        newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }
    @Override
    public User readUser() throws ResourceNotFoundException {
        Long userId = getLoggedInUser().getId();
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User "+userId+" not found."));
    }
    @Override
    public User updateUser(User user) throws ResourceNotFoundException {
        User existingUser = readUser();
        existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
        existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
        existingUser.setPassword(user.getPassword() != null ? bcryptEncoder.encode(user.getPassword()) : existingUser.getPassword());
        existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());
        return userRepository.save(existingUser);
    }
    @Override
    public void deleteUserById() {
        User user = readUser();
        userRepository.delete(user);
    }
    @Override
    public Page<User> getAllUsers(Pageable page) {
        return userRepository.findAll(page);
    }

    @Override
    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found for the email: "+email));
    }
}

