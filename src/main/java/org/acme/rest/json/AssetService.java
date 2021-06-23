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
    }

    public AssetModel getAssetById(UUID id) {

        return this.repository.getAssetById(id).orElseThrow();
    }

    public AssetModel addAsset(AssetModel asset) {
        return this.repository.addAsset(asset);
    }

    /**
     * This deletes an asset by id.
     * @param id UUID of asset.
     */
    public void deleteAssetById(UUID id) {
        //check that key exist, if not, throw error back up.
        this.repository.getAssetById(id).orElseThrow(() -> new NotFoundException());
        
        this.repository.deleteAssetById(id);
    }
}
