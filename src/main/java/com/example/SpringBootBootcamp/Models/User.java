package com.example.SpringBootBootcamp.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.http.HttpStatus;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue
    private int id;

    @Column(name = "user_name")
   // @JsonProperty("Name")  when we need to set the json property explicitly
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id_fk", referencedColumnName = "asset_id")
  //  @JsonManagedReference
    private Asset asset;

    public User(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public User() {
    }

    public int getId() {
        return this.id;
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
