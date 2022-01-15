package com.app.photoapp.api.users.repository;

import com.app.photoapp.api.users.data.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UsersRepo extends CrudRepository<UserEntity, Long> {
    public UserEntity findByEmail(String email);
}
