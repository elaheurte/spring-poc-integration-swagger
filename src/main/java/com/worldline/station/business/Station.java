package com.worldline.station.business;

/**
 * Created by ericlaheurte on 06/10/2016.
 */
public class Station {
    private int id;
    private String name;
    private StationAddress stationAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StationAddress getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(StationAddress stationAddress) {
        this.stationAddress = stationAddress;
    }
}
