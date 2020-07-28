package com.api.user.service;

import com.api.user.dto.request.UserRqDTO;
import com.api.user.dto.response.UserRsDTO;

public interface UserService {

    UserRsDTO createUser(UserRqDTO user);
}
