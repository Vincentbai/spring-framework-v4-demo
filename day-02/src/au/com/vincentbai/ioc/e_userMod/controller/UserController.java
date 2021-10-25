package au.com.vincentbai.ioc.e_userMod.controller;

import au.com.vincentbai.ioc.e_userMod.service.UserService;
import au.com.vincentbai.ioc.e_userMod.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void addUser(){

        userService.addUser();

    }

    public UserController() {
        System.out.println("User Controller!!!");
    }
}
