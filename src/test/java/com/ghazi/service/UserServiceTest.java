package com.ghazi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ContextConfiguration(classes = TestConfig.class)
@ExtendWith(SpringExtension.class)
class UserServiceTest {


    @Autowired
    UserService userService;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void showName() {

//        System.out.println(applicationContext);
        userService.showName();
    }
}