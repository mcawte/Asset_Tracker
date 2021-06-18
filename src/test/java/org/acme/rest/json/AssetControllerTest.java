package org.acme.rest.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

        given(service.getAssetById(asset.id)).willReturn(asset);

        // When

        Response res = controller.getAssetById(asset.id.toString());

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

        UUID validUuid = UUID.randomUUID();
        UUID invalidUuid = UUID.randomUUID();

        given(service.deleteAssetById(validUuid)).willReturn(true);
        given(service.deleteAssetById(invalidUuid)).willReturn(false);

        // When

        Response validRes = controller.deleteAssetById(validUuid);
        Response invalidRes = controller.deleteAssetById(invalidUuid);


        // Then

        assertEquals(validRes.getStatus(), 200);
        assertEquals(invalidRes.getStatus(), 500);
        

    }
}
