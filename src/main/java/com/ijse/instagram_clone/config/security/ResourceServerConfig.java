package com.ijse.instagram_clone.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * Created by :- Intellij Idea
 * Author :- Tharindu
 * Date :- 9/25/2019
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
//                anonymous().disable().
                authorizeRequests()
                .antMatchers("/ideamart/sms/**", "/ideamart/ussd/**", "/ideamart/subscription/**").permitAll()
//                .antMatchers("/**").permitAll()
                //The order of the rules matters and the more specific rules should go first.
                .antMatchers("/ideamart/admin/**").access("hasAuthority('ROLE_ADMIN')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
        http.csrf().disable();
    }

}