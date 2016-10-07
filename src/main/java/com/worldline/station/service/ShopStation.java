package com.worldline.station.service;

import com.worldline.station.business.Order;
import org.springframework.integration.annotation.Gateway;

/**
 * Gateway interface. Provides facade to clients of the process pipeline
 * Will place all Orders into the 'orders' channel
 *
 * @author ericlaheurte
 *
 */
public interface ShopStation {

	@Gateway(requestChannel="ordersChannel")
	void placeOrder(Order order);

}