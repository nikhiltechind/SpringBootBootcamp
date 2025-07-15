package com.example.SpringBootBootcamp.Service;

import com.example.SpringBootBootcamp.DTO.PaginationDTO;
import com.example.SpringBootBootcamp.Mapper.PaginationMapper;
import com.example.SpringBootBootcamp.Models.User;
import com.example.SpringBootBootcamp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService implements UserServiceInterface{

    @Autowired
    private UserRepository userRepository;


    public PaginationDTO<User> getUsers(int limit, int offset, String keyword){


        List<User> users = userRepository.getUsersByLimitOffsetAndKeyword(limit,offset,keyword);
        PaginationMapper<User> mapper =  new PaginationMapper<User>(users,limit,offset,keyword,users.size(),userRepository.findAll().size());
        return mapper.getConvertedDto();
    }


    public User getUserById(int id){
        return userRepository.findById(id).get();
    }


    public User addUser( User user){
        return userRepository.save(user);
    }

    public List<User> addUsers(List<User> users){
          userRepository.saveAll(users);
          return userRepository.findAll();
    }


    public String updateUser( int id,  User user){

        User originalUser = userRepository.getById(id);

        if(originalUser!=null) {
            originalUser.setName(user.getName());
            userRepository.save(originalUser);
            return  "User details updated";
        }
        return "User Not found";
    }
}
