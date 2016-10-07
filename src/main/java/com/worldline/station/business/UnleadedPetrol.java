package com.worldline.station.business;

import java.math.BigDecimal;


public class UnleadedPetrol extends Product {

    private static final long serialVersionUID = 3299079753642372160L;

    public UnleadedPetrol() {
        super();
    }

    public UnleadedPetrol(final BigDecimal price) {
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
