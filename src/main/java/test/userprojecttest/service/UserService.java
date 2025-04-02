package test.userprojecttest.service;

import test.userprojecttest.DTO.UserDetail;
import test.userprojecttest.DTO.UserDto;
import test.userprojecttest.entities.User;

public interface UserService {

    User createUser(UserDto userDto);
    User getUser(long id);
    boolean deleteUser(long id);
    void updateUser(long id, UserDetail userDetail);

}
