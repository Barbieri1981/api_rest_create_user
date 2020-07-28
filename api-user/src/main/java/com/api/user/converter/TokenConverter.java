package com.api.user.converter;

import com.api.user.dto.UserToken;
import com.api.user.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TokenConverter implements Converter<String, UserToken> {

    private static final String SECRET = "ThisIsASecret";

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenConverter.class);

    @Override
    public UserToken convert(final String password) {
        final ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = mapperObj.writeValueAsString(password);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error generating JWT Token", e);
        }

        final String jwtAsString = Jwts.builder()
                .setPayload(jsonStr)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        LOGGER.debug("Convert user {} to JwtToken: {}", password, jwtAsString);
        return new UserToken(jwtAsString);
    }
}
