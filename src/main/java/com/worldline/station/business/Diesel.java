package com.worldline.station.business;

import java.math.BigDecimal;

public class Diesel extends Product {

    private static final long serialVersionUID = -1218825207603759861L;

    public Diesel() {
        super();
    }

    public Diesel(final BigDecimal price) {
        super(price);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        return getClass() == obj.getClass();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
