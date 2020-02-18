package org.gonullu.backend.controller;

import org.gonullu.backend.service.UserService;
import org.gonullu.backend.ws.model.request.UserDetailsRequestModel;
import org.gonullu.backend.ws.model.response.UserRest;
import org.gonullu.backend.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path="/{userId}")
    public UserRest getUser(@PathVariable String userId) throws Exception {
        UserRest returnValue=new UserRest();

        UserDto userDto=userService.getUserByUserId(userId);
        BeanUtils.copyProperties(userDto,returnValue);
        if(userDto.getAdminOf()!=null){
            returnValue.setOrgId(userDto.getAdminOf().getId());
            returnValue.setOrgName(userDto.getAdminOf().getName());
        }
        return  returnValue;
    }

    @PostMapping
    public UserRest userSignUp(@RequestBody UserDetailsRequestModel userDetails) throws Exception {
        UserRest returnValue=new UserRest();

        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(userDetails,userDto);

        UserDto createdUser=userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser,returnValue);
        return  returnValue;
    }
}