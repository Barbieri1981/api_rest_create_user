package com.api.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PHONE")
public class UserPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NUMBER", nullable = false)
    private String number;
    @Column(name = "CITY_CODE", nullable = false)
    private String cityCode;
    @Column(name = "COUNTRY_CODE", nullable = false)
    private String countryCode;
    @Column(name = "USER_ID", nullable = false)
    private long userId;

    public UserPhone() {
    }

    public UserPhone(final String number, final String cityCode, final String countryCode) {
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(final String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(final long userId) {
        this.userId = userId;
    }
}
