package com.fuliaoyi.service.dto;

import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by leo on 17/5/8.
 */
@Data
public class UserDTO {

    public String id;

    public String phoneNumber;

    public String email = "";

    public String token;

    public int gender;

    public String name;

    public String avatarURL;

    public String birthday;

    public String profession;

    public String hobbies;

    public int status = 0;

    public String topic = "";

    public Set<String> calculateHobbiesSet() {
        return new HashSet<>(Arrays.asList(hobbies.split(",")));
    }

    public int calculateMatchScore(UserDTO user) {
        int score = 0;
        Set<String> hobbieSet = calculateHobbiesSet();
        Set<String> targetHobbieSet = user.calculateHobbiesSet();
        hobbieSet.retainAll(targetHobbieSet);
        score += hobbieSet.size();
        if (!topic.isEmpty() && topic.equals(user.topic)) {
            score += 2;
        }
        return score;
    }

//    public static void main(String[] args) {
//        UserDTO user1 = new UserDTO();
//        user1.hobbies = "a,b";
//        user1.topic = "a";
//        UserDTO user2 = new UserDTO();
//        user2.hobbies = "b,c,d";
//        user2.topic = "a";
//
//        System.out.println(user1.calculateMatchScore(user2));
//    }

}
