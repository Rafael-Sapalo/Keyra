package com.user;

import com.user.dto.UserRegisterDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Path("/user")
@ApplicationScoped
public class UserResource {

    UserService userService;

    @Inject
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Path("/register")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response registerUser(UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("error", "Invalid dto")).build();
        }
        return Response.ok(userRegisterDTO).build();
    }

    @GET
    @Path("/me")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response me() {
        return Response.ok().entity("me").build();
    }
}
