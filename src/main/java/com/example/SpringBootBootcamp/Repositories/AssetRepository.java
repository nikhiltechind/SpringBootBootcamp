package com.example.SpringBootBootcamp.Repositories;

import com.example.SpringBootBootcamp.Models.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset,Integer> {
}
