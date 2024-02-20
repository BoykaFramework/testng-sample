package com.github.wasiqb.boyka.api.requests;

import static com.github.wasiqb.boyka.builders.ApiRequest.createRequest;
import static com.github.wasiqb.boyka.enums.RequestMethod.DELETE;
import static com.github.wasiqb.boyka.enums.RequestMethod.GET;
import static com.github.wasiqb.boyka.enums.RequestMethod.PATCH;
import static com.github.wasiqb.boyka.enums.RequestMethod.POST;
import static com.github.wasiqb.boyka.enums.RequestMethod.PUT;

import com.github.wasiqb.boyka.api.pojo.User;
import com.github.wasiqb.boyka.builders.ApiRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserRequest {
    public static ApiRequest createUser (final User user) {
        return createRequest ().method (POST)
            .bodyObject (user)
            .path ("/users")
            .create ();
    }

    public static ApiRequest deleteUser (final String userId) {
        return createRequest ().method (DELETE)
            .path ("/users/${id}")
            .pathParam ("id", userId)
            .create ();
    }

    public static ApiRequest getUser (final String userId) {
        return createRequest ().method (GET)
            .path ("/users/${id}")
            .pathParam ("id", userId)
            .create ();
    }

    public static ApiRequest getUsers () {
        return createRequest ().method (GET)
            .path ("/users")
            .create ();
    }

    public static ApiRequest patchUser (final User user) {
        return createRequest ().method (PATCH)
            .bodyObject (user)
            .path ("/users/{id}")
            .pathParam ("id", Integer.toString (user.getId ()))
            .create ();
    }

    public static ApiRequest updateUser (final User user) {
        return createRequest ().method (PUT)
            .bodyObject (user)
            .path ("/users/{id}")
            .pathParam ("id", Integer.toString (user.getId ()))
            .create ();
    }
}
