package com.watcher.app.service.Impl;

import com.watcher.app.model.post.YouTubePost;
import com.watcher.app.repository.YouTubePostRepo;
import com.watcher.app.service.YouTubePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YouTubePostServiceImpl implements YouTubePostService {
    private final YouTubePostRepo youTubePostRepo;

    @Autowired
    public YouTubePostServiceImpl(YouTubePostRepo youTubePostRepo) {
        this.youTubePostRepo = youTubePostRepo;
    }

    @Override
    public Optional<YouTubePost> findById(Long id) {
        return youTubePostRepo.findById(id);
    }

    @Override
    public List<YouTubePost> findAll() {
        return youTubePostRepo.findAll();
    }

    @Override
    public YouTubePost save(YouTubePost youTubePost) {
        return youTubePostRepo.save(youTubePost);
    }


}
