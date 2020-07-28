package com.api.user.dto.response;

public class ErrorRsDTO {

    private String code;
    private String message;
    private String errorDescription;

    public ErrorRsDTO() {
    }

    public ErrorRsDTO(String code, String message, String errorDescription) {
        this.code = code;
        this.message = message;
        this.errorDescription = errorDescription;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return "ErrorRsDTO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                '}';
    }



}
