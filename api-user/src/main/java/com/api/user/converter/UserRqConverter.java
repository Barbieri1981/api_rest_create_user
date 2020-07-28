package com.api.user.converter;

import com.api.user.dto.request.UserRqDTO;
import com.api.user.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserRqConverter implements Converter<UserRqDTO, User> {

    @Override
    public User convert(final UserRqDTO source) {
        return new User(source.getName(),
                source.getEmail(),
                source.getPassword(),
                true);
    }
}
