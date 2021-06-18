package org.acme.rest.json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class AssetControllerTest {
    @Mock
    private AssetService service;
    @InjectMocks
    private AssetController controller;

    @Test
    public void testGetAssets() {
        // Given
        AssetModel asset = new AssetModel(10, 20, 30);

        given(service.getAssetById(asset.id)).willReturn(asset);

        // When

        Response res = controller.getAssetById(asset.id.toString());

        // Then

        assertEquals((AssetModel) res.getEntity(), asset);
    }
}
