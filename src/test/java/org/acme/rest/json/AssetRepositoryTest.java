package org.acme.rest.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AssetRepositoryTest {
    // @Mock
    // private AssetModel assetModel;
    @InjectMocks
    private AssetRepository repository;

    @Test
    public void testRepository() {
        // Given
        AssetModel asset = new AssetModel(70, 80.0, 90.0);
        AssetModel asset2 = new AssetModel(120, 130.0, 140.0);
        // When

        AssetModel newAsset = repository.addAsset(asset);
        AssetModel returnedAsset = repository.getAssetById(newAsset.getId()).get();
        AssetModel secondAsset = repository.addAsset(asset2);
        List<AssetModel> allAssets = repository.getAssets();
        
        // Then
        assertNotNull(newAsset.getId()); 
        assertEquals(newAsset.getTimestampUtc(), asset.getTimestampUtc());
        assertEquals(newAsset.getLng(), asset.getLng());
        assertEquals(newAsset.getLat(), asset.getLat());
        
        assertNotEquals(asset, newAsset);
        assertEquals(newAsset, returnedAsset);
        assert(allAssets.contains(returnedAsset));
        // the real repository class auto-generates 2 to start with.
        assertEquals(allAssets.size(),4); 

        // Then later when

        repository.deleteAssetById(newAsset.getId());
        allAssets = repository.getAssets();

        // Then
        
        assertEquals(allAssets.size(),3);
        assert(allAssets.contains(secondAsset));
        
    }

    
}
