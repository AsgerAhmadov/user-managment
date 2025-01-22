package service;

import entity.User;
import model.request.UserCreateRequest;
import model.response.UserCreateResponse;
import model.response.UserReadResponse;
import notification.Notification;
import repository.UserRepository;

import java.util.List;

public class UserService {

    private  UserRepository userRepository;
    private  Notification notification;

    public UserService(Notification notification, UserRepository userRepository) {
        this.notification = notification;
        this.userRepository = userRepository;
    }

    public UserCreateResponse createUser(UserCreateRequest userCreateRequest){
        User user = new User();
        user.setId(userCreateRequest.getId());
        user.setEmail(userCreateRequest.getEmail());
        user.setName(userCreateRequest.getName());

        userRepository.addUser(user);
        notification.send("Xosh geldiniz " + user.getName() + " !", user.getEmail());

        UserCreateResponse userCreateResponse = new UserCreateResponse();
        userCreateResponse.setId(user.getId());
        userCreateResponse.setEmail(user.getEmail());
        userCreateResponse.setName(user.getName());
        return userCreateResponse;
    }
//refoster edersen createUser kimi.
    public List<User> listUsers(){
        return userRepository.getAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id);
        //bu metodun facade formasini yazarsan ama geriye UserReadeResponse qaytarsin(facada yazilacaq).
    }
}
