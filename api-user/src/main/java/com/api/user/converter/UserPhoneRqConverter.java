package com.api.user.converter;

import com.api.user.dto.request.PhonesRqDTO;
import com.api.user.entity.UserPhone;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserPhoneRqConverter implements Converter<PhonesRqDTO, UserPhone> {
    @Override
    public UserPhone convert(final PhonesRqDTO source) {
        return new UserPhone(source.getNumber(),
                source.getCityCode(),
                source.getCountryCode());
    }
}
