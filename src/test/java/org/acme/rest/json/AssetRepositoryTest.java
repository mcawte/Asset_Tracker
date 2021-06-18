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
public class AssetRepositoryTest {
    @Mock
    private AssetModel assetModel;
    @InjectMocks
    private AssetRepository repository;

    @Test
    public void testGetAsset() {
        // Given
        AssetModel asset = new AssetModel(70, 80, 90);

        //given(assetModel.id).willReturn(asset.id);
        // given(assetModel.timestamp_utc).willReturn(70);
        // given(assetModel.lng).willReturn((Double) 80.0);
        // given(assetModel.lat).willReturn((Double) 90.0);

        // When

        AssetModel returnedAsset = repository.getAssetById(asset.id);

        // Then 

        assertEquals(returnedAsset,asset);

    }
}
