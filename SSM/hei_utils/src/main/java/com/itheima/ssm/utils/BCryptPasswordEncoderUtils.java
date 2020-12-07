package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encode(String s){
        return bCryptPasswordEncoder.encode(s);
    }

    public static void main(String[] args) {
        String password = "123";   //$2a$10$Y2vkcizctyUZeubOwXZ20uyO2XrAGh76JAuBlq06yYv47lkIIYKEu
        String s = encode(password);
        System.out.println(s);
    }
}
