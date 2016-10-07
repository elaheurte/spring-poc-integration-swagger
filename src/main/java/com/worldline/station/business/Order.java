package com.worldline.station.business;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

    private static final long serialVersionUID = -5362053016861873420L;

    private int orderId;

    private List<OrderItem> orderItems;

    public Order() {
        orderItems = new ArrayList<OrderItem>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getTotalCost() {
        BigDecimal total = new BigDecimal(0);

        for (OrderItem orderItem : orderItems) {
            total = total.add(orderItem.getTotalPrice());
        }

        return total;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(final List<OrderItem> orderItems) {
        this.orderItems = orderItems;
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
    public String toString() {

        final StringBuffer sb = new StringBuffer();
        sb.append("Order [orderId=" + orderId + "] ");
        for (OrderItem orderItem : orderItems) {
            sb.append("\n");
            sb.append(" quantity : " + orderItem.getLiterNumber());
            sb.append(" unitPrice: " + orderItem.getProduct().getUnitPrice());
            sb.append(" total unitPrice: " + orderItem.getTotalPrice());
        }

        sb.append("\n");
        sb.append("total unitPrice: " + this.getTotalCost());

        return sb.toString();
    }
}

