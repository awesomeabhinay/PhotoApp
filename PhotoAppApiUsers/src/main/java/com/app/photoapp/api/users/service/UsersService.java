package com.app.photoapp.api.users.service;

import com.app.photoapp.api.users.shared.UserDto;

public interface UsersService {
    public UserDto createUser(UserDto userDetails);
}
