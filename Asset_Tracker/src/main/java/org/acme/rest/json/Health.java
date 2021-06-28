package org.acme.rest.json;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

// Http and json serialisation
@ApplicationScoped
@Path("/health")
public class Health {

    @GET
    public Response getAssets() {
        return Response.status(200).build();
    }

}
