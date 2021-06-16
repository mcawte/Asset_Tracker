package org.acme.rest.json;


import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//@Path("/assets")
public class AssetResource {

    // private Map<UUID,AssetModel> assets = Collections.synchronizedMap(new LinkedHashMap<>());

    // public AssetResource() {
    //     AssetModel asset;
    //     asset = new AssetModel(1492301050, 151.2099, 33.865143);
    //     assets.put(asset.id, asset);
    //     asset = new AssetModel(1046753105, 29.733333, -70.083333);
    //     assets.put(asset.id, asset);
    // }

    // @GET
    // public Response list() {
    // //public Set<Asset> list() {
    //     //return assets;
    //     System.out.println("The assets are = " + assets);
    //     return Response.ok(assets.values()).build();
    // }

    // @GET
    // @Path("/{id}")
    // //@Consumes(MediaType.APPLICATION_JSON)
    // //public Set<Asset> delete(Asset asset) {
    // public Response getById(@PathParam(value="id") String id) {
    //     UUID assetUUID = UUID.fromString(id);
    //     AssetModel asset = assets.get(assetUUID);
    //     return Response.ok(asset).build();
    // }
    

    // @POST
    // @Consumes(MediaType.APPLICATION_JSON)
    // // public Set<Asset> add(Asset asset) {
    // public Response add(AssetModel asset) {
    //     assets.put(asset.id, asset);
    //     System.out.println("The assets are = " + assets);
    //     return Response.ok(asset.id).build(); // assets;
    // }

    // @DELETE
    // @Path("/{id}")
    // //@Consumes(MediaType.APPLICATION_JSON)
    // //public Set<Asset> delete(Asset asset) {
    // public Response delete(@PathParam(value="id") UUID id) {
    //     assets.remove(id);
    //     return Response.ok().build(); 
    // }



}
