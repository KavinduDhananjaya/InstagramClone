package com.ijse.instagram_clone.config.security;

/**
 * the constants for token and client details
 * Created by :- Intellij Idea
 * Author :- Tharindu
 * Date :- 9/25/2019
 */
class SecurityConstants {

    // admin token details
    protected static final String ADMIN_CLIENT_ID = "admin";
    static final String ADMIN_CLIENT_SECRET = "$2a$04$e/c1/RfsWuThaWFCrcCuJeoyvwCV0URN/6Pn9ZFlrtIWaU/vj/BfG";
    protected static final int ADMIN_ACCESS_TOKEN_VALIDITY_SECONDS = 24 * 60 * 60;
    protected static final int ADMIN_REFRESH_TOKEN_VALIDITY_SECONDS = 60 * 60 * 24 * 30 * 12;

    // mobile user token details
    protected static final String MOBILE_CLIENT_ID = "mobile_user";
    static final String MOBILE_CLIENT_SECRET = "$2a$04$e/c1/RfsWuThaWFCrcCuJeoyvwCV0URN/6Pn9ZFlrtIWaU/vj/BfG";
    protected static final int MOBILE_ACCESS_TOKEN_VALIDITY_SECONDS = 24 * 60 * 60;
    protected static final int MOBILE_REFRESH_TOKEN_VALIDITY_SECONDS = 60 * 60 * 24 * 30 * 12;

    // driver token details
    protected static final String DRIVER_CLIENT_ID = "driver";
    static final String DRIVER_CLIENT_SECRET = "$2a$04$e/c1/RfsWuThaWFCrcCuJeoyvwCV0URN/6Pn9ZFlrtIWaU/vj/BfG";
    protected static final int DRIVER_ACCESS_TOKEN_VALIDITY_SECONDS = 24 * 60 * 60;
    protected static final int DRIVER_REFRESH_TOKEN_VALIDITY_SECONDS = 60 * 60 * 24 * 30 * 12;

    protected static final String GRANT_TYPE_PASSWORD = "password";
    protected static final String AUTHORIZATION_CODE = "authorization_code";
    protected static final String REFRESH_TOKEN = "refresh_token";
    protected static final String IMPLICIT = "implicit";
    protected static final String SCOPE_READ = "read";
    protected static final String SCOPE_WRITE = "write";
    protected static final String TRUST = "trust";

    protected static final String TOKEN_SIGN_IN_KEY = "as466gf";

}
