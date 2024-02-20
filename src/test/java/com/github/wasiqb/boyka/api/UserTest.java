package com.github.wasiqb.boyka.api;

import static com.github.wasiqb.boyka.actions.api.ApiActions.withRequest;
import static com.github.wasiqb.boyka.api.requests.UserRequest.createUser;
import static com.github.wasiqb.boyka.api.requests.UserRequest.getUsers;
import static com.github.wasiqb.boyka.enums.PlatformType.API;
import static com.github.wasiqb.boyka.manager.ParallelSession.clearSession;
import static com.github.wasiqb.boyka.manager.ParallelSession.createSession;
import static com.github.wasiqb.boyka.manager.ParallelSession.getSession;

import com.github.wasiqb.boyka.api.pojo.Address;
import com.github.wasiqb.boyka.api.pojo.Company;
import com.github.wasiqb.boyka.api.pojo.Location;
import com.github.wasiqb.boyka.api.pojo.User;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {
    private User user;

    @BeforeClass
    public void setupClass () {
        createSession (API, "test_json_ph");
    }

    @AfterClass
    public void tearDownClass () {
        clearSession ();
    }

    @Test
    public void testCreateUser () {
        this.user = User.builder ()
            .name ("Wasiq Bhamla")
            .company (Company.builder ()
                .name ("Cognizant")
                .catchPhrase ("Super Company")
                .build ())
            .email ("wbhamla@gmail.com")
            .phone ("9876543210")
            .username ("wbhamla")
            .website ("wasiqb.github.io")
            .address (Address.builder ()
                .city ("Mumbai")
                .suite ("Antilla")
                .street ("Cuff Parade")
                .zipcode ("400100")
                .geo (new Location ("100.019", "-100.33"))
                .build ())
            .build ();
        final var request = createUser (this.user);
        final var response = withRequest (request).execute ();

        response.verifyStatusCode ()
            .isEqualTo (201);

        getSession ().setSharedData ("UserId", response.getResponseData ("id", Integer.class));
    }

    @Test
    public void testGetUsers () {
        final var request = getUsers ();
        final var response = withRequest (request).execute ();

        response.verifyStatusCode ()
            .isEqualTo (200);
        response.verifyIntField ("$.size()")
            .isEqualTo (10);
    }
}
