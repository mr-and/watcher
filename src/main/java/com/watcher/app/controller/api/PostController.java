package com.watcher.app.controller.api;

import com.watcher.app.model.post.YouTubePost;
import com.watcher.app.repository.YouTubePostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/posts/yt")
public class PostController {
    private final YouTubePostRepo youTubePostRepo;

    @Autowired
    public PostController(YouTubePostRepo youTubePostRepo) {
        this.youTubePostRepo = youTubePostRepo;
    }

    @GetMapping("{id}")
    public YouTubePost getPostYouTube(@PathVariable("id") YouTubePost youTubePost) {
        return youTubePost;
    }

    @GetMapping
    public List<YouTubePost> getAllYouTubePosts() {
        return youTubePostRepo.findAll();
    }

    @PostMapping
    public void create(@RequestBody YouTubePost youTubePost) {
        youTubePost.setDataCreated(LocalDateTime.now());
        youTubePostRepo.save(youTubePost);
    }
}
