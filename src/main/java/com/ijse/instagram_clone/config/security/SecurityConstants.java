package com.ijse.instagram_clone.config.security;

class SecurityConstants {

    // user token details
    protected static final String USER_CLIENT_ID = "user";
    static final String USER_CLIENT_SECRET = "$2a$04$e/c1/RfsWuThaWFCrcCuJeoyvwCV0URN/6Pn9ZFlrtIWaU/vj/BfG";
    protected static final int USER_ACCESS_TOKEN_VALIDITY_SECONDS = 24 * 60 * 60;
    protected static final int USER_REFRESH_TOKEN_VALIDITY_SECONDS = 60 * 60 * 24 * 30 * 12;

    protected static final String GRANT_TYPE_PASSWORD = "password";
    protected static final String AUTHORIZATION_CODE = "authorization_code";
    protected static final String REFRESH_TOKEN = "refresh_token";
    protected static final String IMPLICIT = "implicit";
    protected static final String SCOPE_READ = "read";
    protected static final String SCOPE_WRITE = "write";
    protected static final String TRUST = "trust";

    protected static final String TOKEN_SIGN_IN_KEY = "as466gf";

}
