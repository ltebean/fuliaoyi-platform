package com.fuliaoyi.service;


import com.fuliaoyi.mapper.UserMapper;
import com.fuliaoyi.mapper.model.User;
import com.fuliaoyi.service.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by leo on 17/5/8.
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public UserDTO findUserByToken(String token) {
        User user = userMapper.selectByToken(token);
        if (user == null) {
            return null;
        }
        return user.toDTO();
    }

}
