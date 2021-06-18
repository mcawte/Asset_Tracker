package org.acme.rest.json;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class AssetServiceTest {
    @Mock
    private AssetRepository repository;
    @InjectMocks
    private AssetService service;

    @Test
    public void testGetAssetService() {
        // Given
        AssetModel asset = new AssetModel(40, 50, 60);

        given(repository.getAssetById(asset.id)).willReturn(asset);

        // When

        AssetModel returnedAsset = service.getAssetById(asset.id);

        // Then

        assertEquals(returnedAsset, asset);
    }

    @Test
    public void testAddAssetService() {
        // Given
        AssetModel asset = new AssetModel(40, 50, 60);

        UUID uuid = UUID.randomUUID();

        given(repository.addAsset(40, 50.0, 60.0)).willReturn(uuid);

        // When

        service.addAsset(40, 50.0, 60.0);

        AssetModel returnedAsset = service.getAssetById(uuid);

        // Then

        assertEquals(returnedAsset.timestamp_utc, asset.timestamp_utc);
        assertEquals(returnedAsset.lng, asset.lng);
        assertEquals(returnedAsset.lat, asset.lat);
    }
}
