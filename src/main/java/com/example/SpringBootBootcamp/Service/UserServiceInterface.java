package com.example.SpringBootBootcamp.Service;

import com.example.SpringBootBootcamp.DTO.PaginationDTO;
import com.example.SpringBootBootcamp.Models.User;

import java.util.List;

public interface UserServiceInterface {

    public PaginationDTO<User> getUsers(int limit, int offset, String keyword);

    public User getUserById(int id);

    public User addUser( User user);

    public String updateUser( int id,  User user);

    public List<User> addUsers(List<User> users);

   // public List<User> searchUsersByName(String name);
}
