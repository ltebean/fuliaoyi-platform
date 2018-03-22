package com.fuliaoyi.mapper;

import com.fuliaoyi.mapper.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by leo on 17/5/8.
 */
@Mapper
public interface UserMapper {

    void insert(User user);

    User selectById(@Param("id") String id);

    User selectByToken(@Param("token") String token);

    List<User> selectByIds(List<String> ids);


}
