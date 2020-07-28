package com.api.user.service.impl;

import com.api.user.converter.UserPhoneRqConverter;
import com.api.user.converter.UserRqConverter;
import com.api.user.converter.UserRsConverter;
import com.api.user.dto.request.UserRqDTO;
import com.api.user.dto.response.UserRsDTO;
import com.api.user.entity.User;
import com.api.user.entity.UserPhone;
import com.api.user.repository.UserPhoneRepository;
import com.api.user.repository.UserRepository;
import com.api.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRqConverter userRqConverter;
    private final UserRepository userRepository;
    private final UserPhoneRqConverter userPhoneRqConverter;
    private final UserPhoneRepository userPhoneRepository;
    private final UserRsConverter userRsConverter;

    @Autowired
    private UserServiceImpl(final UserRqConverter userRqConverter,
                            final UserRepository userRepository,
                            final UserPhoneRqConverter userPhoneRqConverter,
                            final UserPhoneRepository userPhoneRepository,
                            final UserRsConverter userRsConverter) {
        this.userRqConverter = userRqConverter;
        this.userRepository = userRepository;
        this.userPhoneRqConverter = userPhoneRqConverter;
        this.userPhoneRepository = userPhoneRepository;
        this.userRsConverter = userRsConverter;
    }

    @Override
    public UserRsDTO createUser(final UserRqDTO userRq) {
        LOGGER.debug("Creating user {}", userRq);
        final User user = this.userRepository.save(this.userRqConverter.convert(userRq));
        LOGGER.debug("Creating user phones {}", userRq.getPhones());

        List<UserPhone> phones = userRq.getPhones().stream().map(e -> this.userPhoneRqConverter.convert(e))
                .collect(Collectors.toList());

        phones.forEach( phone -> {
            phone.setUserId(user.getId());
            this.userPhoneRepository.save(phone);
        });

        return this.userRsConverter.convert(user);
    }
}
