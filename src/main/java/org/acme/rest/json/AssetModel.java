package org.acme.rest.json;

import java.util.UUID;

// Data class that gets stored in the DB via the ORM (JRA) and also 
// converted to json
public class AssetModel {

    public UUID id;
    public int timestamp_utc;
    public double lng;
    public double lat;

    public AssetModel(int timestamp_utc, double lng, double lat) {
        this.id = UUID.randomUUID();
        this.timestamp_utc = timestamp_utc;
        this.lng = lng;
        this.lat = lat;
    }

}
