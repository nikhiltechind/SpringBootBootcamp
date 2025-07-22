package com.example.SpringBootBootcamp.DTO;

import com.example.SpringBootBootcamp.Models.Asset;
import com.example.SpringBootBootcamp.Models.User;

class AssetDto{
    public String assetName;
    public String assetType;
}

public class UserDto {

    public String name;
    public AssetDto asset;

    public  UserDto(User user){
        this.name = user.getName();
        AssetDto assetDto = new AssetDto();
        assetDto.assetName = user.getAsset().getName();
        assetDto.assetType = user.getAsset().getType();
        this.asset = assetDto;
    }
// Fix the breaking code , fix the cyclic error and Jakson error
    public UserDto getUserDto(){
      return this;
    }
}
