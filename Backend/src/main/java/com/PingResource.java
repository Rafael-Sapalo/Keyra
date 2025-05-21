package com;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/ping")
@ApplicationScoped
public class PingResource {

    @GET
    public Response ping() {
        return Response.ok("pong").build();
    }
}
