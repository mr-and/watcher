package com.watcher.app.model.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "youtube_posts")
public class YouTubePost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "header", nullable = false)
    @Size(message = "Максимум 100 символов", max = 100)
    private String header;

    @Column (name = "content")
    @Size(message = "Максимум 10 000 символов", max = 10000)
    private String content;

    @Column (name = "rating")
    private Long rating;

    @Column (name = "video_url_link")
    private String videoUrlLink;

    @ElementCollection
    @Column(name = "tags", nullable = false)
    private Set<String> tags = new HashSet<>();

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataCreated;

}
