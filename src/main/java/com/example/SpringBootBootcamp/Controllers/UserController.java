package com.example.SpringBootBootcamp.Controllers;


import com.example.SpringBootBootcamp.DTO.PaginationDTO;
import com.example.SpringBootBootcamp.Models.Asset;
import com.example.SpringBootBootcamp.Models.User;
import com.example.SpringBootBootcamp.Repositories.UserRepository;
import com.example.SpringBootBootcamp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public PaginationDTO<User> getUsers(
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false, defaultValue = "0") int offset,
            @RequestParam(required = false, defaultValue = "") String keyword) {

        return userService.getUsers(limit, offset, keyword);
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
       return  userService.getUserById(id);
    }

    @PostMapping
   public User addUser(@RequestBody User user){
     return userService.addUser(user);
   }

   @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user){
       return userService.updateUser(id,user);
   }

   @PostMapping("/users")
    public List<User> addUsers(@RequestBody List<User> users){
        return userService.addUsers(users);
   }

//   @GetMapping("/addAsset")
//    public User (@RequestBody Asset)
}
