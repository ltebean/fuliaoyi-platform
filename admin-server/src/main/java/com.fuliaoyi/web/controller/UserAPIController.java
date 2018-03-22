package com.fuliaoyi.web.controller;



import com.fuliaoyi.service.UserService;
import com.fuliaoyi.service.dto.UserDTO;
import com.fuliaoyi.web.annotation.LoginRequired;
import com.fuliaoyi.web.controller.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



/**
 * Created by leo on 16/6/7.
 */
@RestController
@RequestMapping("/api/user/v1")
public class UserAPIController {

    @Autowired
    UserService userService;


    @LoginRequired
    @GetMapping("/me")
    @RequestMapping(method = RequestMethod.GET, value = "/me")
    public Response findHotTopic(@RequestAttribute UserDTO user) {
        return new Response(user);
    }

}
