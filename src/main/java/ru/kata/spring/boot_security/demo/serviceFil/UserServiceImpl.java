//package ru.kata.spring.boot_security.demo.serviceFil;
//
//import com.SpringSecurity.security.sources.daoFil.UserDao;
//import com.SpringSecurity.security.sources.model.User;
//import com.SpringSecurity.security.sources.userDetails.MyUserDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//public class UserServiceImpl implements UserService, UserDetailsService {
///**перенёс @transactional в @service, потому что посмотрел, в основном реализуют тут*/
//    private final UserDao userDao;
//    private  PasswordEncoder passwordEncoder;
//
//
//    @Autowired
//    public UserServiceImpl(UserDao usersDao) {
//        this.userDao = usersDao;
//    }
//
//    public UserDao getUserDao() {
//        return userDao;
//    }
//
//    public PasswordEncoder getPasswordEncoder() {
//        return passwordEncoder;
//    }
//
//    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    @Transactional
//    public void addUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userDao.addUserToDatabase(user);
//
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return userDao.getAllUsersFromDatabase();
//    }
//
//    @Override
//    public User getUser(long id) {
//        Optional<User> user = userDao.getUserByIdFromDatabase(id);
//        if (user.isEmpty()) {
//            throw new RuntimeException("user with id = " + id + "not found");
//        }
//        return user.get();
//    }
//
//    @Override
//    @Transactional
//    public void updateUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userDao.updateUserInDatabase(user);
//    }
//
//    @Override
//    @Transactional
//    public void deleteUserById(long id) {
//        userDao.deleteUserFromDatabaseById(id);
//    }
//
//    @Override
//    @Transactional
//    public void deleteUser(User user) {
//        userDao.deleteUserFromDatabaseById(user.getId());
//    }
//
//    @Override
//    public User getUserByName(String name) {
//        Optional<User> user = userDao.loadUserByUsername(name);
//        if (user.isEmpty()) {
//            throw new RuntimeException("user with name = " + name + " not found");
//        }
//        return user.get();
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        Optional<User> user =  userDao.loadUserByUsername(username);
//        if (user.isEmpty()) {
//            throw new UsernameNotFoundException("user with name = " + username + " not found");
//        }
//        return new MyUserDetails(user.get());
//    }
//}
