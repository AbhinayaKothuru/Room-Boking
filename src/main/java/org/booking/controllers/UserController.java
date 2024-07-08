package org.booking.controllers;

import org.booking.beans.User;
import org.booking.services.UserService;

import java.util.Scanner;

public class UserController {

    UserService userService = new UserService();

    public User getInput()
    {
        try {
            User user =  userService.input();
            return user;

        }
        catch(Exception e)
        {
            System.out.println(e+"Userservice");
        }
        return null;
    }

    public void addUser(User user)
    {
        try{
            userService.addUserSvc(user);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public User loginUser() {
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter username");
            String username = scanner.nextLine();
            System.out.println("Enter password");
            String password = scanner.nextLine();
            return userService.loginUserSvc(username,password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
