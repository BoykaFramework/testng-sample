package com.github.wasiqb.boyka.api.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Comment {
    private String body;
    private String email;
    private int    id;
    private String name;
    private int    postId;
}
