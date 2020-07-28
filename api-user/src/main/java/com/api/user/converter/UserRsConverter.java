package com.api.user.converter;

import com.api.user.dto.response.UserRsDTO;
import com.api.user.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserRsConverter implements Converter<User, UserRsDTO> {

    @Override
    public UserRsDTO convert(final User source) {
        return new UserRsDTO(source.getId(),
                source.getCreateDate(),
                source.getModifiedDate(),
                source.getLastLogin(),
                source.isActive());

    }
}
