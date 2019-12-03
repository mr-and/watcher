package com.watcher.app.repository;

import com.watcher.app.model.posts.YouTubePosts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YouTubePostsRepo extends JpaRepository<YouTubePosts, Long> {

    List<YouTubePosts> findAll();

    YouTubePosts save(YouTubePosts youTubePosts);

}
