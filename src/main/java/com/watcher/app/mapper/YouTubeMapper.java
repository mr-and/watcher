package com.watcher.app.mapper;

import com.watcher.app.dto.YouTubePostDto;
import com.watcher.app.model.post.YouTubePost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface YouTubeMapper {

    YouTubeMapper MAPPER = Mappers.getMapper(YouTubeMapper.class);

    @Mapping(target = "dataCreated", source = "dataCreated", dateFormat = "dd.MM.yyyy")
    YouTubePostDto toYouTubePostDto(YouTubePost youTubePost);

    List<YouTubePostDto> toYouTubePostDtos(List<YouTubePost> youTubePosts);

    YouTubePost toYouTubePost(YouTubePostDto youTubePostDto);
}
