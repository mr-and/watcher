package com.watcher.app.controller.api;

import com.watcher.app.dto.YouTubePostDto;
import com.watcher.app.mapper.YouTubeMapper;
import com.watcher.app.service.YouTubePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

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
        return YouTubeMapper.MAPPER.toYouTubePostDto(youTubePostService.findById(id).get());
    }

    @GetMapping
    public List<YouTubePostDto> getAllYouTubePosts() {
        return YouTubeMapper.MAPPER.toYouTubePostDtos(youTubePostService.findAll());
    }

    @PostMapping
    public void create(@Valid @RequestBody YouTubePostDto youTubePostDto) {
        youTubePostDto.setDataCreated(LocalDateTime.now());
        youTubePostService.save(YouTubeMapper.MAPPER.toYouTubePost(youTubePostDto));
    }

}
