package com.watcher.app.controller.api;

import com.watcher.app.dto.YouTubePostDto;
import com.watcher.app.mapper.YouTubeMapper;
import com.watcher.app.model.post.YouTubePost;
import com.watcher.app.service.YouTubePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts/yt")
public class PostController {
    private final YouTubePostService youTubePostService;

    @Autowired
    public PostController(YouTubePostService youTubePostService) {
        this.youTubePostService = youTubePostService;
    }


    @GetMapping("/{id}")
    public YouTubePostDto getPostYouTube(@PathVariable("id") Long id) {
        Optional<YouTubePost> youTubePost = youTubePostService.findById(id);
        return YouTubeMapper.MAPPER.toYouTubePostDto(youTubePost.get());
    }

    @GetMapping
    public List<YouTubePostDto> getAllYouTubePosts() {
        return YouTubeMapper.MAPPER.toYouTubePostDtos(youTubePostService.findAll());
    }

    @PostMapping
    public void create(@RequestBody YouTubePostDto youTubePostDto) {
        youTubePostDto.setDataCreated(LocalDateTime.now());
        youTubePostService.save(YouTubeMapper.MAPPER.toYouTubePost(youTubePostDto));
    }
}
