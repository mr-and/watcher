package com.watcher.app.service;

import com.watcher.app.model.post.YouTubePost;

import java.util.List;
import java.util.Optional;

public interface YouTubePostService {
    Optional<YouTubePost> findById(Long id);
    List<YouTubePost> findAll();
    YouTubePost save(YouTubePost youTubePost);

}
