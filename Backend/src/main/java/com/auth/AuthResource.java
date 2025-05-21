package com.auth;

import com.auth.dto.LoginRequestDTO;
import com.auth.dto.RefreshRequestDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/auth")
@ApplicationScoped
public class AuthResource {

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequestDTO loginRequestDTO) {
        return Response.ok(loginRequestDTO).build();
    }

    @POST
    @Path("/refresh")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response refresh(RefreshRequestDTO refreshRequestDTO) {
        if (refreshRequestDTO.getRefreshToken() == null || refreshRequestDTO.getRefreshToken().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("error", "Invalid refresh token"))
                    .build();
        }
        return Response.ok().entity(refreshRequestDTO).build();
    }

    @POST
    @Path("/logout")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout() {
        return Response.ok().build();
    }
}
