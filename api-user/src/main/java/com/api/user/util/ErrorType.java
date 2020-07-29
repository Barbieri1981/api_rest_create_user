package com.api.user.util;

public enum ErrorType {

    INTERNAL_SERVER_ERROR("user_api_001", "Internal error"),
    INVALID_MAIL_FORMAT("user_api_002", "Bad Request"),
    INVALID_PASSWORD_FORMAT("user_api_003", "Bad Request"),
    EMAIL_EXISTS("user_api_004", "Bad Request");

    private final String code;
    private final String description;

    private ErrorType(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ErrorType{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
