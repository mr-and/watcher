package com.watcher.app.controller.api;

import com.watcher.app.model.posts.YouTubePosts;
import com.watcher.app.repository.YouTubePostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/posts/yt")
public class PostController {
    private final YouTubePostsRepo youTubePostsRepo;

    @Autowired
    public PostController(YouTubePostsRepo youTubePostsRepo) {
        this.youTubePostsRepo = youTubePostsRepo;
    }

    @GetMapping("{id}")
    public YouTubePosts getPostYouTube(@PathVariable("id") YouTubePosts youTubePosts) {
        return youTubePosts;
    }

    @GetMapping
    public List<YouTubePosts> getAllYouTubePosts() {
        return youTubePostsRepo.findAll();
    }

    @PostMapping
    public void create(@RequestBody YouTubePosts youTubePosts) {
        youTubePosts.setDataCreated(LocalDateTime.now());
        youTubePostsRepo.save(youTubePosts);
    }
}
