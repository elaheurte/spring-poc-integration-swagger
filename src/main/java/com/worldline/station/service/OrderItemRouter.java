package com.worldline.station.service;

import com.worldline.station.business.Diesel;
import com.worldline.station.business.LeadedPetrol;
import com.worldline.station.business.OrderItem;
import com.worldline.station.business.UnleadedPetrol;
import org.apache.log4j.Logger;

/**
 * @author ericlaheurte
 */
public class OrderItemRouter {

    private static final Logger log = Logger.getLogger(OrderItemRouter.class);

    public String routeOrder(OrderItem orderItem) {

        log.debug("*** [OrderItemRouter] ****");

        String channel = "";
        if (isUnleadedPetrol(orderItem)) {
            channel = "unleadedPetrolItemsChannel";
        } else if (isDiesel(orderItem)) {
            channel = "dieselItemsChannel";
        } else if (isLeadedPetrol(orderItem)) {
            channel = "leadedPetrolItemsChannel";
        }

        log.debug("*** [OrderItemRouter] sending item : " + orderItem.getProduct().getClass() + " to " + channel + " ****");

        return channel;
    }

    private Boolean isUnleadedPetrol(OrderItem orderItem) {
        return orderItem.getProduct() instanceof UnleadedPetrol;
    }

    private Boolean isDiesel(OrderItem orderItem) {
        return orderItem.getProduct() instanceof Diesel;
    }

    private Boolean isLeadedPetrol(OrderItem orderItem) {
        return orderItem.getProduct() instanceof LeadedPetrol;
    }
}
