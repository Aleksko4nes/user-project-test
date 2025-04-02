package test.userprojecttest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import test.userprojecttest.DTO.UserDetail;
import test.userprojecttest.DTO.UserDto;
import test.userprojecttest.entities.User;
import test.userprojecttest.exceptions.UserNotFoundException;
import test.userprojecttest.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Override
    public User createUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setTlf(userDto.getTlf());
        user.setCompanyId(userDto.getCompanyId());
        return userRepository.save(user);
    }

    @Override
    public User getUser(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        return user.get();
    }

    @Override
    public boolean deleteUser(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        userRepository.delete(user.get());
        return true;
    }

    @SneakyThrows
    @Override
    public void updateUser(long id, UserDetail userDetail) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        objectMapper.updateValue(user, userDetail);
        userRepository.save(user);
    }
}
