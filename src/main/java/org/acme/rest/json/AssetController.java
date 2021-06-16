package org.acme.rest.json;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// Http and json serialisation
@ApplicationScoped
@Path("/assets")
public class AssetController {
    private AssetService service;

    @Inject
    public AssetController(AssetService service) {
        this.service = service;
    }

    @GET
    public Response list() {
        System.out.println("The assets are = " + this.service.getAssets());
        return Response.ok(this.service.getAssets()).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam(value = "id") String id) {
        AssetModel asset = this.service.getAssetById(UUID.fromString(id));
        return Response.ok(asset).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(int timestamp_utc, double lng, double lat) {
        UUID newId = this.service.addAsset(timestamp_utc, lng, lat);
        System.out.println("The assets are = " + this.service.getAssets());
        return Response.ok(newId).build(); // assets;
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam(value = "id") UUID id) {
        boolean success = this.service.removeAssetById(id);
        if (success) {
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }
    }
}
