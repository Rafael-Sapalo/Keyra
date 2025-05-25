package com.user;

import com.user.dto.UserRegisterDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;
import java.util.UUID;

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
        String userToken = this.userService.registerUser(
                userRegisterDTO.getUsername(),
                userRegisterDTO.getPassword(),
                userRegisterDTO.getEmail()
        );

        if (userToken == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("error", "Invalid user")).build();
        }

        return Response.ok(Map.of("access_token", userToken)).build();
    }

    @GET
    @Path("/me")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response me() {
        return Response.ok().entity("me").build();
    }

    @GET
    @Path("/{userID}")
    public Response getUser(@PathParam("userID") String userID) {
        UserEntity user = this.userService.getUserInfo(UUID.fromString(userID));
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(user).build();
    }
}
