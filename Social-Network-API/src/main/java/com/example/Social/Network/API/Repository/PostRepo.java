package com.example.Social.Network.API.Repository;

import com.example.Social.Network.API.Model.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

Post findAllById(long Id);
}
