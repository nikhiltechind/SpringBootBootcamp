package com.example.SpringBootBootcamp.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "asset")
public class Asset {

    @Id
    @GeneratedValue
    @Column(name = "asset_id")
    private int id;
// User -> Asset
    @Column(name="asset_name")
    private String name;
    @Column(name = "asset_type")
    private String type;

    @OneToOne(mappedBy = "asset", fetch = FetchType.EAGER) // for bidirectional
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
