package org.acme.rest.json;

public class Asset {

    public String id;
    public int timestamp_utc;
    public double lng;
    public double lat;

    public Asset() {

    }

    public Asset(String id, int timestamp_utc, double lng, double lat) {
        this.id = id;
        this.timestamp_utc = timestamp_utc;
        this.lng = lng;
        this.lat = lat;
    }

}
