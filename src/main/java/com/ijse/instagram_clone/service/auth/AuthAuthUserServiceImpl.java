package com.ijse.instagram_clone.service.auth;

import com.ijse.instagram_clone.dto.UserDTO;
import com.ijse.instagram_clone.repository.UserRepository;
import com.ijse.instagram_clone.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Service(value = "userService")
public class AuthAuthUserServiceImpl implements AuthUserService, UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {

            UserDTO user = getUser(username);
            return new User(user.getEmail(), user.getPassword(),
                    getAuthority("USER"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Something went wrong, " +e.getMessage());
        }
    }

    private UserDTO getUser(String username) {
        com.ijse.instagram_clone.entity.User userByEmail = userRepository.findUserByEmail(username);
        if (userByEmail == null) {
            throw new CustomException(404, "No user found for : " + username);
        }

        UserDTO userDTO= new UserDTO();
        userDTO.setEmail(userByEmail.getEmail());
        userDTO.setName(userByEmail.getName());
        userDTO.setPassword(userByEmail.getPassword());
        return userDTO;
    }

    @Override
    @Transactional
    public UserDTO getUserForToken(String username) {
        try {
            UserDTO user = getUser(username);
            user.setPassword(null);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Cannot get user details ! " + e.getMessage());
        } finally {
            httpServletRequest.getSession().invalidate();
        }
    }


    private List<SimpleGrantedAuthority> getAuthority(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }
}
