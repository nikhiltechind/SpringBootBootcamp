package com.example.SpringBootBootcamp.Service;

import com.example.SpringBootBootcamp.DTO.PaginationDTO;
import com.example.SpringBootBootcamp.DTO.UserDto;
import com.example.SpringBootBootcamp.Exceptions.CustomExceptions.UserNotFoundException;
import com.example.SpringBootBootcamp.Mapper.PaginationMapper;
import com.example.SpringBootBootcamp.Models.Asset;
import com.example.SpringBootBootcamp.Models.User;
import com.example.SpringBootBootcamp.Repositories.AssetRepository;
import com.example.SpringBootBootcamp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssetRepository assetRepository;


    public PaginationDTO<User> getUsers(int limit, int offset, String keyword){


        List<User> users = userRepository.getUsersByLimitOffsetAndKeyword(limit,offset,keyword);
        PaginationMapper<User> mapper =  new PaginationMapper<User>(users,limit,offset,keyword,users.size(),userRepository.findAll().size());
        return mapper.getConvertedDto();
    }


    public UserDto getUserById(int id){

        User user = userRepository.findById(id).get();
       UserDto userDto = new UserDto(user);
       return  userDto.getUserDto();

    }


    public User addUser( User user){

        /* This commented code is required when we dont use cascade in the model*/
//        if(user.getAsset()!=null) {
//            Asset asset = user.getAsset();
//            // System.out.println(asset.);
//            assetRepository.save(asset); // making transient asset object persistent by saving in Db first
//        }
        User res = userRepository.save(user);

        return  res;
    }

    public List<User> addUsers(List<User> users){
          userRepository.saveAll(users);
          return userRepository.findAll();
    }


    public ResponseEntity<String> updateUser(int id, User user){
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User not found with ID: " + id);
        }

        UserDto userDto = new UserDto(optionalUser.get());
        return new ResponseEntity<>("User Updated", HttpStatus.ACCEPTED);
    }
}
