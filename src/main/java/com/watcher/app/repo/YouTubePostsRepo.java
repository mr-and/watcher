package com.watcher.app.repo;

import com.watcher.app.domain.posts.YouTubePosts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YouTubePostsRepo extends JpaRepository<YouTubePosts, Long> {

    List<YouTubePosts> findAll();

    YouTubePosts save(YouTubePosts youTubePosts);

}
