package org.booking.services;

import org.booking.beans.User;
import org.booking.dao.UserDao;

import java.util.List;
import java.util.Scanner;

public class UserService {

    private UserDao userDao =  new UserDao();

    private String inputHelper(String detail)
    {
        System.out.println("Enter the "+detail);
        Scanner sc = new Scanner(System.in);
        String detailInput = sc.nextLine();
        return detailInput;
    }

    public User input()
    {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        String name = this.inputHelper("name");
        String password = this.inputHelper("password");
        String email = this.inputHelper("email");
        String phoneNumber = this.inputHelper("Phone Number");
        System.out.println("Enter the age");
        int age = sc.nextInt();
        if(name.isEmpty() || password.isEmpty() || email.isEmpty() || phoneNumber.isEmpty())
        {
            System.out.println("Mandatory fields are missing. User can't be created");
            return null;
        }

        if(!email.contains("@") || password.length() < 5)
        {
            System.out.println("User cant be created as email ID is invalid or password length is less than 5");
            return null;
        }

        user.setName(name);
        user.setMail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setAge(age);

        return user;
    }

    public boolean addUserSvc(User user) {

        return userDao.add(user);
    }

    public User loginUserSvc(String username,String password) {

        List<User> users = userDao.getAllUsers();
        if(users == null) return null;
        for(User user: users)
        {
            if(user.getName().equals(username) && user.getPassword().equals(password))
            {
                return user;
            }
        }
        return null;
    }
}
