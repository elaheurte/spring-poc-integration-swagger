package com.worldline.station.business;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderItem implements Serializable {

    private static final long serialVersionUID = 8550809367351405777L;

    private Product product;

    private int literNumber;

    public OrderItem(Product item) {
        this.product = item;
        literNumber = 1;
    }

    /**
     * No arg construtor
     */
    public OrderItem() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getLiterNumber() {
        return literNumber;
    }

    public void incrementQuantity() {
        literNumber++;
    }

    public void decrementQuantity() {
        literNumber--;
    }

    public void setQuantity(int literNumber) {
        literNumber = literNumber;
    }

    public BigDecimal getTotalPrice() {
        return product.getUnitPrice().multiply(new BigDecimal(literNumber));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((product == null) ? 0 : product.hashCode());
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
        OrderItem other = (OrderItem) obj;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\n OrderItem [product=" + product + ", literNumber=" + literNumber + " total cost=" + getTotalPrice() + "]";
    }

}
