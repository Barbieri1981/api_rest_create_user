package com.api.user.service;

import com.api.user.converter.TokenConverter;
import com.api.user.converter.UserPhoneRqConverter;
import com.api.user.converter.UserRqConverter;
import com.api.user.converter.UserRsConverter;
import com.api.user.dto.request.PhonesRqDTO;
import com.api.user.dto.request.UserRqDTO;
import com.api.user.dto.response.UserRsDTO;
import com.api.user.entity.User;
import com.api.user.exception.UserException;
import com.api.user.repository.UserPhoneRepository;
import com.api.user.repository.UserRepository;
import com.api.user.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static javafx.beans.binding.Bindings.when;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Spy
    private UserRqConverter userRqConverter;
    @Mock
    private UserRepository userRepository;
    @Spy
    private UserPhoneRqConverter userPhoneRqConverter;
    @Mock
    private UserPhoneRepository userPhoneRepository;
    @Spy
    private UserRsConverter userRsConverter;
    @Spy
    private TokenConverter tokenConverter;

    private static final String NAME = "testName";
    private static final String  EMAIL = "testEmail@dominio.com";
    private static final String PASSWORD = "123PqrstadF";


    @Before
    public void setup() {
        this.userService = new UserServiceImpl(this.userRqConverter,
                this.userRepository,
                this.userPhoneRqConverter,
                this.userPhoneRepository,
                this.userRsConverter,
                this.tokenConverter);
    }

    @Test
    public void whenCreateUserIsCalledAndEmailIsInvalidThenThrowException () {
        final UserRqDTO request = createUserRq();
        request.setEmail("wrongEmail");
        try {
            this.userService.createUser(request);
        } catch (UserException e) {
            Assert.assertEquals("Email has an invalid format", e.getMessage());
        }
    }

    @Test
    public void whenCreateUserIsCalledAndPasswordIsInvalidThenThrowException () {
        final UserRqDTO request = createUserRq();
        request.setPassword("wrongPassword");
        try {
            this.userService.createUser(request);
        } catch (UserException e) {
            Assert.assertEquals("Password has an invalid format", e.getMessage());
        }
    }

    @Test
    public void whenCreateUserIsCalledAndDataIsValidThenReturnData () {
        final UserRqDTO request = createUserRq();
        final User user = createUser();
        Mockito.when(this.userRepository.save(any(User.class))).thenReturn(user);

        final UserRsDTO result = this.userService.createUser(request);

        assertNotNull(result);
        assertEquals(request.getName(), request.getName());
        verify(this.userRqConverter).convert(request);
        verify(this.userRepository).save(any());
    }

    private UserRqDTO createUserRq() {
        List<PhonesRqDTO> phones = Arrays.asList(new PhonesRqDTO());
        return new UserRqDTO(NAME, EMAIL, PASSWORD, phones);
    }

    private User createUser() {
        return new User(NAME, EMAIL, PASSWORD, true);
    }

}
