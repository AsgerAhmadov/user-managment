package facade;

import model.response.UserReadResponse;

import java.util.List;

public interface UserFacade {

    List<UserReadResponse> findAll();

    UserReadResponse findByUserId(Long id);
}
