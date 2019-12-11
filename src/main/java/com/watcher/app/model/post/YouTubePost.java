package com.watcher.app.model.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "youtube_posts")
public class YouTubePost implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotBlank
    @Length(message = "Максимум 100 символов", max = 100)
    @Column(name = "header", nullable = false)
    private String header;

    @Length(message = "Максимум 10 000 символов", max = 10000)
    @Column(name = "content")
    private String content;

    @Column(name = "rating")
    private Long rating;

    @URL(regexp = "(?:https?:\\/\\/)?(?:www\\.)?youtu\\.?be(?:\\.com)?\\/?.*(?:watch|embed)?(?:.*v=|v\\/|\\/)([\\w\\-_]+)\\&?")
    @Column(name = "video_url_link")
    private String videoUrlLink;

    @ElementCollection(targetClass = String.class)
    @Column(name = "tags")
    private Set<String> tags = new HashSet<>();

    @Column(updatable = false)
    private LocalDateTime dataCreated;

}
