package com.worldline.station.service;

import com.worldline.station.business.Order;
import com.worldline.station.business.OrderItem;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Receives the collection of order items that have been processed
 * for the discount reduction.
 *
 * @author ericlaheurte
 *
 */
public class OrderCompleter {
	
	private static final Logger log = Logger.getLogger(OrderCompleter.class);

	public Order prepareDelivery(List<OrderItem> orderItems) {
		final Order order = new Order();
		order.setOrderItems(orderItems);

		return order;
	}
}
