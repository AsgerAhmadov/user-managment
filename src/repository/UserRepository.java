package repository;

import constant.UserConstant;
import entity.User;
import exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> users = new ArrayList<User>();

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getAll(){
        return users;
    }

    public User findById(Long id){

        return users.stream().filter(foundUser -> foundUser.getId() == id).findFirst()
                .orElseThrow(() -> new UserNotFoundException(UserConstant.NOT_FOUND)) ;
    }
}
