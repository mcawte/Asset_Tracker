package org.acme.rest.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;


//Storage of data
@ApplicationScoped
public class AssetRepository {

    private Map<UUID, AssetModel> assets = Collections.synchronizedMap(new LinkedHashMap<>());

    /**
     * This is the class constructor.
     */
    public AssetRepository() {
        AssetModel asset;
        asset = new AssetModel(1492301050, 151.2099, 33.865143);
        assets.put(asset.getId(), asset);
        asset = new AssetModel(1046753105, 29.733333, -70.083333);
        assets.put(asset.getId(), asset);
    }

    public List<AssetModel> getAssets() {
        // Should always return a list, empty or with Assets in it.
        return new ArrayList<>(this.assets.values());
    }

    public Optional<AssetModel> getAssetById(UUID id) {
        return Optional.ofNullable(this.assets.get(id));
    }

    /**
     * This creates a new asset.
     * 
     * @param asset this is the inputted asset that does not yet have an id.
     * @return this is the returned asset with id.
     */
    public AssetModel addAsset(AssetModel asset) {
        // Should always add an asset and return one
        AssetModel newAsset = new AssetModel(asset.getTimestampUtc(),
         asset.getLng(), asset.getLat());
        this.assets.put(newAsset.getId(), newAsset);
        return newAsset;
    }

    /**
     * Deletes asset by id.
     * @param id UUID of asset.
     */
    public void deleteAssetById(UUID id) {
        // Should throw exception if there is a problem, but no scope for this with
        // current implementation.
        this.assets.remove(id);
    }
}
