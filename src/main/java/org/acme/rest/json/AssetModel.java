package org.acme.rest.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import lombok.Data;


/** Data class that gets stored in the DB via the ORM (JRA) and also ...
 converted to json **/
@Data
public class AssetModel {

    @JsonIgnore
    private UUID id;
    private int timestampUtc;
    private double lng;
    private double lat;

    /**
     * This is the class constructor.
     * @param timestampUtc is the time stamp in UTC
     * @param lng is the longitude
     * @param lat is the lattitude
     */
    public AssetModel(int timestampUtc, double lng, double lat) {
        this.id = UUID.randomUUID();
        this.timestampUtc = timestampUtc;
        this.lng = lng;
        this.lat = lat;
    }

}
