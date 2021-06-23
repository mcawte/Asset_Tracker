package org.acme.rest.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.times;
import static org.mockito.Mockito.never;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
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

        given(repository.getAssetById(asset.getId())).willReturn(Optional.of(asset));

        // When

        AssetModel returnedAsset = service.getAssetById(asset.getId());

        // Then

        assertEquals(returnedAsset, asset);
        assertThrows(NoSuchElementException.class, () -> service.getAssetById(UUID.randomUUID()));
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
    public void testDeleteAssetService() {
        // Given
        AssetModel asset = new AssetModel(40, 50, 60);
        given(repository.getAssetById(asset.getId())).willReturn(Optional.of(asset));
        
        // When
        //service.addAsset(asset);
        service.deleteAssetById(asset.getId());

        // Then
        then(this.repository).should(times(1)).deleteAssetById(asset.getId());

       // assertThrows(NotFoundException.class, () -> service.deleteAssetById(UUID.randomUUID()));
        //assertThrows(NoSuchElementException.class, () -> service.getAssetById(asset.getId()));
        
    }

    @Test
    public void testDeleteAssetServiceAltPath() {
        // Given
        AssetModel asset = new AssetModel(40, 50, 60);
        given(repository.getAssetById(asset.getId())).willReturn(Optional.empty());
        
        // When
        //service.addAsset(asset);
        
        assertThrows(NotFoundException.class, () -> service.deleteAssetById(asset.getId()));
        // Then
        then(this.repository).should(never()).deleteAssetById(asset.getId());
        

        
        
    }

}
