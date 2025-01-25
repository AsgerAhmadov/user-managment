package facade.impl;

import constant.UserConstant;
import entity.User;
import exception.UserNotFoundException;
import facade.UserFacade;
import model.response.UserReadResponse;
import service.UserService;
import java.util.List;

public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserReadResponse> findAll() {
        List<User> users = userService.listUsers();
        return userService.listUsers().stream()
                .map(user -> {
                    UserReadResponse userReadResponse = new UserReadResponse();
                    userReadResponse.setName(user.getName());
                    userReadResponse.setId(user.getId());
                    userReadResponse.setEmail(user.getEmail());
                    return userReadResponse;
                }).toList();
    }

    @Override
    public UserReadResponse findByUserId(Long id) {
        List<User> users = userService.listUsers();

        for (User user : users) {
            if (user.getId().equals(id)) {
                UserReadResponse userReadResponse = new UserReadResponse();
                userReadResponse.setId(user.getId());
                userReadResponse.setEmail(user.getEmail());
                userReadResponse.setName(user.getName());
                return userReadResponse;
            }
        }
        throw new UserNotFoundException(UserConstant.NOT_FOUND);
    }

}