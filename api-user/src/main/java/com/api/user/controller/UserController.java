package com.api.user.controller;

import com.api.user.dto.request.UserRqDTO;
import com.api.user.dto.response.ErrorRsDTO;
import com.api.user.dto.response.UserRsDTO;
import com.api.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("wfm/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Creates user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = UserRqDTO.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorRsDTO.class)
    })
    public ResponseEntity<UserRsDTO> createUser(@RequestBody final UserRqDTO user) {
        return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.OK);
    }

}
