package com.watcher.app.repository;

import com.watcher.app.model.post.YouTubePost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface YouTubePostRepo extends JpaRepository<YouTubePost, Long> {

    List<YouTubePost> findAll();
    YouTubePost save(YouTubePost youTubePost);
    Optional<YouTubePost> findById(Long id);

}
