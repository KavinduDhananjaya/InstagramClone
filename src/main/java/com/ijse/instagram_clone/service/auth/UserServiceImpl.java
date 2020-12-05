package com.ijse.instagram_clone.service.auth;

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
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private AdminRepository adminRepository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {

            AdminDTO admin = getAdminUser(username);
            return new User(admin.getUsername(), admin.getPassword(),
                    getAuthority("ADMIN"));
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Exception : " + e.getMessage());
            throw new IlocateException("Something went wrong, " +e.getMessage());
        }
    }

    private AdminDTO getAdminUser(String username) {
        PmAdmin admin = adminRepository.findByUserName(username);
        if (admin == null) {
            throw new IlocateException(404, "No admin found for : " + username);
        }

        AdminDTO adminDTO= new AdminDTO();
        adminDTO.setUsername(admin.getUserName());
        adminDTO.setPassword(admin.getPassword());
        return adminDTO;
    }

    @Override
    @Transactional
    public AdminDTO getUserForToken(String username) {
        try {
            LOGGER.info("Get user for token method \n Username : " + username );
            AdminDTO admin = getAdminUser(username);
            admin.setPassword(null);
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Exception : " + e.getMessage());
            throw new IlocateException("Cannot get user details ! " + e.getMessage());
        } finally {
            httpServletRequest.getSession().invalidate();
        }
    }


    private List<SimpleGrantedAuthority> getAuthority(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }
}
