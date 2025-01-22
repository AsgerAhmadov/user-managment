package facade.impl;

import entity.User;
import facade.UserFacade;
import model.response.UserReadResponse;
import service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class UserFacadeImpl implements UserFacade {

    private UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;

    }

    @Override
    public List<UserReadResponse> findAll() {
//        return userService.listUsers(); bunun ucun maping(userreadereresponse qayitsin deye)
//        etmek lazimdir ve streamla yazcan.
        return null;
//
//        return userService.listUsers().stream()
//                .map(user -> new UserReadResponse()
//                        .setId(user.getId())
////                        .setEmail(user.getEmail())
////                        .setName(user.getName()))
////                .toList();
////    }
//
//    //bu metodun facade formasini yazarsan ama geriye UserReadeResponse qaytarsin(facada yazilacaq).yazdim
//    public UserReadResponse getUserId(Long id){
//        if (userService != null){
//            return new UserReadResponse()
//                    .setId(userService.getId())
//                    .setEmail(userService.getEmail())
//                    .setName(userService.getName());
//
//        }else {
//            return null;
//        }
//    }
//}
    }
}