package com.github.wasiqb.boyka.api.pojo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private Address address;
    private Company company;
    private String  email;
    private int     id;
    private String  name;
    private String  phone;
    private String  username;
    private String  website;
}
