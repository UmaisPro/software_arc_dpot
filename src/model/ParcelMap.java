package model;

import java.util.HashMap;
import java.util.Map;

public class ParcelMap {
    private Map<String, Parcel> parcels;

    public ParcelMap() {
        parcels = new HashMap<>();
    }

    public void addParcel(Parcel parcel) {
        parcels.put(parcel.getId(), parcel);
    }

    public Parcel getParcelById(String id) {
        return parcels.get(id);
    }

    public Map<String, Parcel> getAllParcels() {
        return parcels;
    }
}