package org.acme.rest.json;

import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    public Response getAssets() {
        System.out.println("The assets are = " + this.service.getAssets());
        return Response.ok(this.service.getAssets()).build();
    }

    @GET
    @Path("/{id}")
    public Response getAssetById(@PathParam(value = "id") String id) {
        AssetModel asset = this.service.getAssetById(UUID.fromString(id));
        return Response.ok(asset).build();
    }

    /**
     * This is the end point that takes in JSON of an asset with no id and creates
     * an asset with an id.
     * 
     * @param asset this JSON asset does not yet have an id.
     * @return this returned asset will have an id.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    // @Produces(MediaType.APPLICATION_JSON)
    public Response addAsset(AssetModel asset) {
        AssetModel newAsset = this.service.addAsset(asset);
        System.out.println("The assets are = " + this.service.getAssets());
        return Response.ok(newAsset).build(); // assets;
    }

    /**
     * This deletes an asset by id.
     * 
     * @param id UUID of asset.
     * @return returns a Response.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteAssetById(@PathParam(value = "id") UUID id) {
        try {
            this.service.deleteAssetById(id);
        } catch (NotFoundException e) {
            return Response.status(404).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
        return Response.status(200).build();
    }
}
