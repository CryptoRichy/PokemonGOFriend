package Interfaces;

import Models.User;

import java.util.List;

public interface UserDAOI {

    public List<User> getUsers();

    public List<User> getUsersBylocation(String loc);




}
