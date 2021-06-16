package org.acme.rest.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;


//Storage of data
@ApplicationScoped
public class AssetRepository {

    private Map<UUID,AssetModel> assets = Collections.synchronizedMap(new LinkedHashMap<>());

    public AssetRepository() {
        AssetModel asset;
        asset = new AssetModel(1492301050, 151.2099, 33.865143);
        assets.put(asset.id, asset);
        asset = new AssetModel(1046753105, 29.733333, -70.083333);
        assets.put(asset.id, asset);
    }

    public List<AssetModel> getAssets() {
        return new ArrayList<>(this.assets.values()) ;
    }    

    public AssetModel getAssetById(UUID id) {
        return this.assets.get(id);
    }

    public UUID addAsset(int timestamp_utc, double lng, double lat) {
        AssetModel newAsset = new AssetModel(timestamp_utc, lng, lat);
        this.assets.put(newAsset.id, newAsset);
        return newAsset.id;
    }

    public boolean removeAssetById(UUID id) {
        this.assets.remove(id);
        return true; // A method to determine success could be added here later
    }
}
