package com.github.wasiqb.boyka.api.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Company {
    private String bs;
    private String catchPhrase;
    private String name;
}
