package org.acme.rest.json;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/assets")
public class AssetResource {

    private Set<Asset> assets = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public AssetResource() {
        assets.add(new Asset("0", 1492301050, 151.2099, 33.865143));
        assets.add(new Asset("23", 1046753105, 29.733333, -70.083333));

    }

    @GET
    public Set<Asset> list() {
        return assets;
    }

    @POST
    public Set<Asset> add(Asset asset) {
        assets.add(asset);
        return assets;
    }

    @DELETE
    public Set<Asset> delete(Asset asset) {
        assets.removeIf(existingAsset -> existingAsset.id.contentEquals(asset.id));
        return assets;
    }

}
