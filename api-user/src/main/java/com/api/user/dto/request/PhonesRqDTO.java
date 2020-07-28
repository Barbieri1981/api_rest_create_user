package com.api.user.dto.request;

public class PhonesRqDTO {

    private String number;
    private String cityCode;
    private String countryCode;

    public PhonesRqDTO() {
    }

    public PhonesRqDTO(final String number, final String cityCode, final String countryCode) {
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
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

    @Override
    public String toString() {
        return "PhonesRqDTO{" +
                "number='" + number + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
