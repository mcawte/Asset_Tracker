package org.acme.rest.json;

import java.util.UUID;

public class Asset {

    public UUID id;
    public int timestamp_utc;
    public double lng;
    public double lat;

    public Asset(int timestamp_utc, double lng, double lat) {
        this.id = UUID.randomUUID();
        this.timestamp_utc = timestamp_utc;
        this.lng = lng;
        this.lat = lat;
    }

}
