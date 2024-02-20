package com.github.wasiqb.boyka.api.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Album {
    private int    id;
    private String title;
    private int    userId;
}
