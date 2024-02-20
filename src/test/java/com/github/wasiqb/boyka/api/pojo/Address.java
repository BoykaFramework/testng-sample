package com.github.wasiqb.boyka.api.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Address {
    private String   city;
    private Location geo;
    private String   street;
    private String   suite;
    private String   zipcode;
}
