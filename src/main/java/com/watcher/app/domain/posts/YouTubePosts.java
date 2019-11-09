package com.watcher.app.domain.posts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.watcher.app.domain.views.ViewsYouTube;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "youtube_posts")
@Data
@NoArgsConstructor
public class YouTubePosts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @JsonView(ViewsYouTube.Full.class)
    private Long id;

    @Column(name = "header")
    @JsonView(ViewsYouTube.Full.class)
    private String header;

    @Column (name = "body")
    @JsonView(ViewsYouTube.Full.class)
    private String body;

    @Column(name = "tag")
    @JsonView(ViewsYouTube.Full.class)
    private String tag;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @JsonView(ViewsYouTube.Full.class)
    private LocalDateTime dataCreated;

}
