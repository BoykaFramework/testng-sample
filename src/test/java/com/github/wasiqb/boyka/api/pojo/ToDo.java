package com.github.wasiqb.boyka.api.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ToDo {
    private boolean completed;
    private int     id;
    private String  title;
    private int     userId;
}
