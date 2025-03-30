package test.userprojecttest.service;


import lombok.AllArgsConstructor;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import test.userprojecttest.entoties.User;
import test.userprojecttest.repository.UserRepo;



@Service
@AllArgsConstructor
public class UserService {



    private final UserRepo userRepo;

    public User findUserById(long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public User updateUser(User userSource) {
        User user = userRepo.findById(userSource.getId())
                .orElseThrow(()-> new RuntimeException("User not found"));

        user.setFirstName(userSource.getFirstName());
        user.setLastName(userSource.getLastName());
        user.setTlf(userSource.getTlf());

        return userRepo.save(user);
    }

    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

    public Page<User> getAllUsers(int num, int size) {
        return userRepo.findAll(PageRequest.of(num, size));
    }
}
