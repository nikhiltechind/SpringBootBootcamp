package com.example.SpringBootBootcamp.Controllers;


import com.example.SpringBootBootcamp.Models.Asset;
import com.example.SpringBootBootcamp.Repositories.AssetRepository;
import com.example.SpringBootBootcamp.Service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/asset")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @PostMapping("/addAsset")
    public Asset addAsset(@RequestBody Asset asset){
      return  assetService.addAsset(asset);
    }

    @PutMapping("assignUser/{userId}/{assetId}")
    public String assignUser(@PathVariable int userId, @PathVariable int assetId){
        return assetService.assignUser(userId,assetId);
    }

    @GetMapping("/assets")
    public List<Asset> getAssets(){
        return assetService.getAssets();
    }

    @DeleteMapping("/{assetId}")
    public String removeAsset(@PathVariable int assetId){
        return  assetService.removeAsset(assetId);
    }
}
