package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String name;
    private List<String> parcelIds;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.parcelIds = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getParcelIds() {
        return parcelIds;
    }

    public void addParcel(String parcelId) {
        this.parcelIds.add(parcelId);
    }
}
