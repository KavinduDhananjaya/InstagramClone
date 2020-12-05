package com.ijse.instagram_clone.service.auth;

import com.ijse.instagram_clone.dto.UserDTO;

public interface AuthUserService {
    UserDTO getUserForToken(String username);
}
