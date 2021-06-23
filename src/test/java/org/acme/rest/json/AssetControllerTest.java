package org.acme.rest.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.when;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.times;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class AssetControllerTest {
    @Mock
    private AssetService service;
    @InjectMocks
    private AssetController controller;

    @Test
    public void testGetAssetById() {
        // Given
        AssetModel asset = new AssetModel(10, 20, 30);

        given(service.getAssetById(asset.getId())).willReturn(asset);

        // When

        Response res = controller.getAssetById(asset.getId().toString());

        // Then

        assertEquals((AssetModel) res.getEntity(), asset);
    }

    @Test
    public void testGetAssets() {
        // Given
        List<AssetModel> assets = new ArrayList<>();
        AssetModel asset;
        asset = new AssetModel(500, 600.0, 700.0);
        assets.add(asset);
        asset = new AssetModel(800, 900.0, 1000.0);
        assets.add(asset);

        given(service.getAssets()).willReturn(assets);

        // When

        Response res = controller.getAssets();

        // Then

        assertEquals(res.getEntity(), assets);
    }

    @Test
    public void addAsset() {
        // Given
        AssetModel asset = new AssetModel(800, 900.0, 1000.0);

        given(service.addAsset(asset)).willReturn(asset);

        // When

        Response res = controller.addAsset(asset);

        // Then

        assertEquals(res.getEntity(), asset);
    }

    @Test
    public void deleteAssetById() {
        // Given

        AssetModel asset = new AssetModel(40, 50, 60);
        //given(service.getAssetById(asset.getId())).willReturn(asset);

        // When
        controller.deleteAssetById(asset.getId());

        // Then
        then(this.service).should(times(1)).deleteAssetById(asset.getId());

    }

    @Test
    public void deleteAssetByWrongId() {
        // Given

        AssetModel asset = new AssetModel(40, 50, 60);
        doThrow(NotFoundException.class).when(service).deleteAssetById(asset.getId());

        // When
        //controller.deleteAssetById(asset.getId());
       
        Response response = controller.deleteAssetById(asset.getId());
        // Then
        System.out.println("The res is: " + response.getStatus());
        assertEquals(response.getStatus(), 404);

    }

    @Test
    public void deleteAssetByIdException() {
        // Given

        AssetModel asset = new AssetModel(40, 50, 60);
        doThrow(Exception.class).when(service).deleteAssetById(asset.getId());

        // When
        //controller.deleteAssetById(asset.getId());
       
        Response response = controller.deleteAssetById(asset.getId());
        // Then
        System.out.println("The res2 is: " + response.getStatus());
        assertEquals(response.getStatus(), 500);

    }
}
