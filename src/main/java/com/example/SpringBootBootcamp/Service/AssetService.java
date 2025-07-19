package com.example.SpringBootBootcamp.Service;

import com.example.SpringBootBootcamp.Models.Asset;
import com.example.SpringBootBootcamp.Models.User;
import com.example.SpringBootBootcamp.Repositories.AssetRepository;
import com.example.SpringBootBootcamp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private UserRepository userRepository;

    public Asset addAsset( Asset asset){
        return  assetRepository.save(asset);
    }

    public String assignUser(int userId, int assetId){
         Asset asset = assetRepository.findById(assetId).get();
         if(asset!=null){
             User user = userRepository.findById(userId).get();
             if(user!=null){
                 user.setAsset(asset);
                 userRepository.save(user);
                 return "Assigned Asset";
             }
             return "Invalid userId";
         }
         return "Asset not found";
    }


    public List<Asset> getAssets(){
        return assetRepository.findAll();
    }

    public String removeAsset( int assetId){
        try {

       /*********************************
        *
        * The below code is required when we don't  use Cascase in the entity , if we don't add this code then it will
        * throw transientObjectException i.e first manually remove or unassign from parent which is refering the child
        * object which is going to be delted from Db. so we are making it persistent to work correctly without using cascade
        *
            List<User> users = userRepository.findAll();
            for(User user : users){
                if(user.getAsset() != null && user.getAsset().getId() == assetId){
                    user.setAsset(null);
                    userRepository.save(user);
                    break;
                }

            }
*************************************/
            assetRepository.deleteById(assetId);
            return  "deleted";
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
       return "invalid assetId";

    }
}
