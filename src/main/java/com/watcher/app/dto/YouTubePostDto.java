package com.watcher.app.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class YouTubePostDto {

    private Long id;
    private String header;
    private String content;
    private Long rating;
    private String videoUrlLink;
    private Set<String> tags;
    private LocalDateTime dataCreated;
}
