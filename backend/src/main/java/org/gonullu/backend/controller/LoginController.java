package org.gonullu.backend.controller;

import org.gonullu.backend.service.UserService;
import org.gonullu.backend.ws.model.request.UserDetailsRequestModel;
import org.gonullu.backend.ws.model.response.UserRest;
import org.gonullu.backend.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping
    @RequestMapping("/api/user")
    public UserRest userSignUp(@RequestBody UserDetailsRequestModel userDetails) throws Exception {
        UserRest returnValue=new UserRest();

        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);

        UserDto createdUser=userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser,returnValue);
        return  returnValue;
    }
}
