package com.fuliaoyi.mapper.model;

import com.fuliaoyi.service.dto.UserDTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * Created by leo on 17/5/8.
 */
@Data
public class User {

    public String id;

    public String phoneNumber = "";

    public String email = "";

    public String passwordHash = "";

    public String token = "";

    public int gender = 0;

    public int status = 0;

    public String avatarURL = "";

    public String name = "";

    public String birthday = "";

    public String profession = "";

    public String hobbies = "";

    public String topic = "";



    public UserDTO toDTO() {
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(this, dto);
        dto.token = null;
        return dto;
    }

}
