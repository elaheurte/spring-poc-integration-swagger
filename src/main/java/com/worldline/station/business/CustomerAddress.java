package com.worldline.station.business;

import java.io.Serializable;

/**
 * @author ericlaheurte
 */
public class CustomerAddress extends Address implements Serializable {

    private static final long serialVersionUID = -3977964168622401031L;

    public CustomerAddress() {
        type = AddressType.CUSTOMER_ADDRESS;
    }

    public CustomerAddress(final String firstLineOfAddress, final String city, final String postCode) {
        super(firstLineOfAddress, city, postCode);
        type = AddressType.CUSTOMER_ADDRESS;
    }

}
