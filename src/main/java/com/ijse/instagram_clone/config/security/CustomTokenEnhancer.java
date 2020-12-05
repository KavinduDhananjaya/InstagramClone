package com.ijse.instagram_clone.config.security;
import com.ijse.instagram_clone.dto.UserDTO;
import com.ijse.instagram_clone.service.auth.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to add additional json user data into the access token
 */
@Component
public class CustomTokenEnhancer extends JwtAccessTokenConverter {

    private final AuthUserService userService;

    @Autowired
    public CustomTokenEnhancer(AuthUserService userService) {
        this.userService = userService;
    }

    /**
     * @param oAuth2AccessToken    the access token which the client gets when successfully authenticated
     * @param oAuth2Authentication the authentication details of the user
     * @return the token with additional user data
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        final Map<String, Object> additionalInfo = new HashMap<>();

        User user = (User) oAuth2Authentication.getPrincipal();

        UserDTO userForToken = userService.getUserForToken(user.getUsername());

        additionalInfo.put("user", userForToken);

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
        // set custom claims
        return super.enhance(oAuth2AccessToken, oAuth2Authentication);
    }
}
