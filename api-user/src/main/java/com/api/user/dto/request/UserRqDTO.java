package com.api.user.dto.request;

import java.util.List;

public class UserRqDTO {

    private String name;
    private String email;
    private String password;
    private List<PhonesRqDTO> phones;

    public UserRqDTO() {
    }

    public UserRqDTO(final String name, final String email, final String password, final List<PhonesRqDTO> phones) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public List<PhonesRqDTO> getPhones() {
        return this.phones;
    }

    public void setPhones(final List<PhonesRqDTO> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "UserRqDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phones=" + phones +
                '}';
    }
}
