package com.api.user.service.impl;

import com.api.user.converter.TokenConverter;
import com.api.user.converter.UserPhoneRqConverter;
import com.api.user.converter.UserRqConverter;
import com.api.user.converter.UserRsConverter;
import com.api.user.dto.request.UserRqDTO;
import com.api.user.dto.response.UserRsDTO;
import com.api.user.entity.User;
import com.api.user.entity.UserPhone;
import com.api.user.exception.UserException;
import com.api.user.repository.UserPhoneRepository;
import com.api.user.repository.UserRepository;
import com.api.user.service.UserService;
import com.api.user.util.ErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRqConverter userRqConverter;
    private final UserRepository userRepository;
    private final UserPhoneRqConverter userPhoneRqConverter;
    private final UserPhoneRepository userPhoneRepository;
    private final UserRsConverter userRsConverter;
    private final TokenConverter tokenConverter;


    @Autowired
    public UserServiceImpl(final UserRqConverter userRqConverter,
                            final UserRepository userRepository,
                            final UserPhoneRqConverter userPhoneRqConverter,
                            final UserPhoneRepository userPhoneRepository,
                            final UserRsConverter userRsConverter,
                            final TokenConverter tokenConverter) {
        this.userRqConverter = userRqConverter;
        this.userRepository = userRepository;
        this.userPhoneRqConverter = userPhoneRqConverter;
        this.userPhoneRepository = userPhoneRepository;
        this.userRsConverter = userRsConverter;
        this.tokenConverter = tokenConverter;
    }

    @Override
    public UserRsDTO createUser(final UserRqDTO userRq) {
        LOGGER.debug("Creating user {}", userRq);

        validateEmail(userRq.getEmail());
        validatePassword(userRq.getPassword());

        final User user = this.userRqConverter.convert(userRq);
        user.setUserToken(this.tokenConverter.convert(user.getPassword()).getJwtToken());
        final User savedUser = this.userRepository.save(user);

        createPhoneUser(userRq, user);

        return this.userRsConverter.convert(savedUser);
    }

    private void createPhoneUser(final UserRqDTO userRq, final User user) {
        LOGGER.debug("Creating user phones {}", userRq.getPhones());
        List<UserPhone> phones = userRq.getPhones().stream().map(e -> this.userPhoneRqConverter.convert(e))
                .collect(Collectors.toList());

        phones.forEach( phone -> {
            phone.setUserId(user.getId());
            this.userPhoneRepository.save(phone);
        });
    }

    private void validatePassword(final String password) {

        final Pattern passwrodRegExp = Pattern.compile("^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,20}$");

        final Matcher matchPasswordRegExp = passwrodRegExp.matcher(password);

        if (!matchPasswordRegExp.find()) {
            throw new UserException("Password has an invalid format", ErrorType.INVALID_PASSWORD_FORMAT, HttpStatus.BAD_REQUEST.value());
        }

    }


    private void validateEmail(final String email) {

        final Pattern emailRegExp = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        final Matcher matchEmailRegExp = emailRegExp.matcher(email);

        if (!matchEmailRegExp.find()) {
            throw new UserException("Email has an invalid format", ErrorType.INVALID_MAIL_FORMAT, HttpStatus.BAD_REQUEST.value());
        }

    }
}
