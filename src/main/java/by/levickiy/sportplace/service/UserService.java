package by.levickiy.sportplace.service;

import by.levickiy.sportplace.dto.UserDto;
import by.levickiy.sportplace.entity.User;
import by.levickiy.sportplace.exceptions.IncorrectPasswordException;
import by.levickiy.sportplace.exceptions.UserNameNotFoundException;

public interface UserService {
    User login(UserDto userDto) throws UserNameNotFoundException, IncorrectPasswordException;
    void register(UserDto userDto) throws Exception;
    boolean isAdmin(String username);
    User getUserByUsername(String username);
}
