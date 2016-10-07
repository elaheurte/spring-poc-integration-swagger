package com.worldline.station.business;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

    private static final long serialVersionUID = -429708360254033010L;

    protected BigDecimal unitPrice;

    /**
     * no arg constructor
     */
    public Product() {

    }

    public Product(final BigDecimal unitPrice) {
        this.unitPrice = round(unitPrice);
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Round for currency values
     *
     * @param value
     * @return
     */
    private BigDecimal round(final BigDecimal value) {
        return value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Product [unitPrice="
                + unitPrice + "]";
    }


}
