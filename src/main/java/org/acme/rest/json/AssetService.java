package org.acme.rest.json;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

// Orchestration and business logic
@ApplicationScoped
public class AssetService {

    private AssetRepository repository;

    @Inject
    public AssetService(AssetRepository repository) {
        this.repository = repository;
    }

    public List<AssetModel> getAssets() {
        return this.repository.getAssets();
    };

    public AssetModel getAssetById(UUID id) {
        return this.repository.getAssetById(id);
    }

    public UUID addAsset(int timestamp_utc, double lng, double lat) {
        return this.repository.addAsset(timestamp_utc, lng, lat);
    }

    public boolean deleteAssetById(UUID id) {
        return this.repository.deleteAssetById(id);
    }
}
