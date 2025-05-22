package com.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;

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
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.MULTIPART_FORM_DATA })
    public Response registerUser() throws URISyntaxException {
        return Response.created(new URI("/user/register")).build();
    }

    @GET
    @Path("/me")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response me() {
        return Response.ok().entity("me").build();
    }
}
