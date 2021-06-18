package org.acme.rest.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class AssetServiceTest {
    @Mock
    private AssetRepository repository;
    @InjectMocks
    private AssetService service;

    @Test
    public void testGetAssetByIdService() {
        // Given
        AssetModel asset = new AssetModel(40, 50, 60);

        given(repository.getAssetById(asset.id)).willReturn(asset);

        // When

        AssetModel returnedAsset = service.getAssetById(asset.id);

        // Then

        assertEquals(returnedAsset, asset);
    }

    @Test
    public void testGetAssetsService() {
        // Given
        List<AssetModel> assets = new ArrayList<>();
        AssetModel asset;
        asset = new AssetModel(500, 600.0, 700.0);
        assets.add(asset);
        asset = new AssetModel(800, 900.0, 1000.0);
        assets.add(asset);

        given(repository.getAssets()).willReturn(assets);

        // When

        List<AssetModel> returnedAssets = service.getAssets();

        // Then

        assertEquals(returnedAssets, assets);
    }

    @Test
    public void testAddAssetService() {
        // Given
        AssetModel asset = new AssetModel(40, 50, 60);

        given(repository.addAsset(asset)).willReturn(asset);

        // When

        AssetModel returnedAsset = service.addAsset(asset);

        // Then

        assertEquals(returnedAsset, asset);

    }

    @Test
    public void deleteAssetById() {
        // Given

        UUID uuid = UUID.randomUUID();

        given(repository.deleteAssetById(uuid)).willReturn(true);

        // When

        Boolean bool = service.deleteAssetById(uuid);

        // Then

        assertEquals(bool, true);
        

    }
}
