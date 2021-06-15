package org.acme.rest.json;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/assets")
public class AssetResource {

    private Set<Asset> assets = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public AssetResource() {
        assets.add(new Asset(1492301050, 151.2099, 33.865143));
        assets.add(new Asset(1046753105, 29.733333, -70.083333));

    }

    @GET
    public Response list() {
    //public Set<Asset> list() {
        //return assets;
        return Response.ok(assets).build();
    }

    @POST
    public Set<Asset> add(Asset asset) {
        assets.add(asset);
        return assets;
    }

    @DELETE
    public Set<Asset> delete(Asset asset) {
        assets.removeIf(existingAsset -> existingAsset.id.equals(asset.id));
        return assets;
    }

}
