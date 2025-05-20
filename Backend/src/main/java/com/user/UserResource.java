package com.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/user")
@ApplicationScoped
public class UserResource {

    UserService userService;

    @Inject
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/me")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response me() {
        UserEntity user = this.userService.registerUser("sam", "azerty", "test.email@outlook.com");
        if (user == null) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("invalid user theres error").build();
        }
        return Response.ok(user).build();
    }
}
