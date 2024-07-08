package org.booking.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.booking.beans.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserDao {

    private String filePath = "src/main/java/org/booking/data/Users.json";
    public List<User> getAllUsers(){
        Gson gson = new Gson();
        List<User> users = Collections.emptyList();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            users = gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());
        } catch (FileNotFoundException e) {
            users = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
           
        }
        return users;
    }

    public boolean add(User user)
    {
        Gson gson = new Gson();
        List<User> users = Collections.emptyList();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            users = gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());
        } catch (FileNotFoundException e) {
            users = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        if(users == null)  users = new ArrayList<>();
        users.add(user);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
