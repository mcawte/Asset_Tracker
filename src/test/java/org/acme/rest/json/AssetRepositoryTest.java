package org.acme.rest.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.InstanceOf;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AssetRepositoryTest {
    // @Mock
    // private AssetModel assetModel;
    @InjectMocks
    private AssetRepository repository;

    @Test
    public void testGetAssetById() {
        // Given
        AssetModel asset = new AssetModel(70, 80.0, 90.0);
        
        

        // When

        AssetModel returnedAsset = repository.getAssetById(asset.id);

        // Then
        assertEquals(returnedAsset.id, asset.id);
        assertEquals(returnedAsset.timestamp_utc, asset.timestamp_utc);
        assertEquals(returnedAsset.lng, asset.lng);
        assertEquals(returnedAsset.lat, asset.lat);

    }

    @Test
    public void testAddAsset() {
        // Given
        AssetModel asset = new AssetModel(70, 80.0, 90.0);

        // When

        AssetModel returnedAsset = repository.addAsset(asset);

        // Then
        assertTrue(returnedAsset.id instanceof UUID);
        assertEquals(returnedAsset.timestamp_utc, asset.timestamp_utc);
        assertEquals(returnedAsset.lng, asset.lng);
        assertEquals(returnedAsset.lat, asset.lat);

    }
}
