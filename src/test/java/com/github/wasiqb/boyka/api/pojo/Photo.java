package com.github.wasiqb.boyka.api.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Photo {
    private int    albumId;
    private int    id;
    private String thumbnailUrl;
    private String title;
    private String url;
}
