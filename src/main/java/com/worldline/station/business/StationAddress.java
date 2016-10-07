package com.worldline.station.business;

import java.io.Serializable;

/**
 * Class to represent Shipping Address
 *
 * @author ericlaheurte
 */
public class StationAddress extends Address implements Serializable {

    private static final long serialVersionUID = 7858082156191079323L;

    public StationAddress() {
        type = AddressType.STATION_ADDRESS;
    }

    public StationAddress(final String firstLineOfAddress, final String city, final String postCode) {
        super(firstLineOfAddress, city, postCode);
        type = AddressType.STATION_ADDRESS;
    }

}
