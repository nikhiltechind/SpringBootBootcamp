package com.example.SpringBootBootcamp.Repositories;

import com.example.SpringBootBootcamp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM user_table u WHERE LOWER(u.user_name) LIKE LOWER(CONCAT('%', :keyword, '%')) LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<User> getUsersByLimitOffsetAndKeyword(@Param("limit") int limit, @Param("offset") int offset, @Param("keyword") String keyword);


}
