package com.api.user.converter;

import com.api.user.dto.request.PhonesRqDTO;
import com.api.user.entity.UserPhone;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class UserPhoneRqConverterTest {

    private static final String NUMBER = "13455678";
    private static final String CITY_CODE = "12455";
    private static final String COUNTRY_CODE = "12344";

    @Test
    public void whenUserPhoneRqConverterTestIsCalledThenReturnEntity() {
        final UserPhoneRqConverter converter = new UserPhoneRqConverter();
        final PhonesRqDTO request = createPhoneRq();

        final UserPhone result = converter.convert(request);

        assertNotNull(result);
        assertEquals(request.getCityCode(), result.getCityCode());
    }

    private PhonesRqDTO createPhoneRq() {
        return new PhonesRqDTO(NUMBER, CITY_CODE, COUNTRY_CODE);
    }

}
