package com.example.SpringBootBootcamp.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue
    private int Id;

    @Column(name = "user_name")
   // @JsonProperty("Name")  when we need to set the json property explicitly
    private String name;

    @OneToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    public User(int id, String name) {
        Id = id;
        this.name = name;
    }

    public User() {
    }

    public int getId() {
        return Id;
    }



    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
