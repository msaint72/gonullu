package org.gonullu.backend.service.impl;

import org.gonullu.backend.domain.UserEntity;
import org.gonullu.backend.exception.AlreadyExistException;
import org.gonullu.backend.repository.UserRepository;
import org.gonullu.backend.service.UserService;
import org.gonullu.backend.ws.shared.dto.UserDto;
import org.gonullu.backend.ws.shared.dto.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto user) {
        if(userRepository.findByEmail(user.getEmail())!=null){
            throw new AlreadyExistException(user.getEmail()+" kullanıcısı önceden kayıt olmuş.");
        }
        UserEntity userEntity= new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userEntity.setUserId(utils.generateUserId(30));
        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        UserEntity storedUserEntity= userRepository.save(userEntity);
        UserDto returnValue=new UserDto();
        BeanUtils.copyProperties(storedUserEntity,returnValue);
        return returnValue;
    }

    @Override
    public UserDto getUser(String email) {
        UserEntity userEntity=userRepository.findByEmail(email);
        if(userEntity==null) throw new UsernameNotFoundException(email);
        UserDto returnValue=new UserDto();
        BeanUtils.copyProperties(userEntity,returnValue);
        return returnValue;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity=userRepository.findByUserId(userId);
        if(userEntity==null) throw new UsernameNotFoundException(userId);
        UserDto returnValue=new UserDto();
        BeanUtils.copyProperties(userEntity,returnValue);
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity=userRepository.findByEmail(email);
        if(userEntity==null) throw new UsernameNotFoundException(email);

        return new User(userEntity.getEmail(),userEntity.getEncryptedPassword(),new ArrayList<>());
    }
}
