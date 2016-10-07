package com.worldline.station.service;

import com.worldline.station.business.Order;
import org.apache.log4j.Logger;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;

/**
 * Splits an Order into it's constituent OrderItems
 *
 * @author ericlaheurte
 *
 */
public class OrderSplitter extends AbstractMessageSplitter{

	private static final Logger log = Logger.getLogger(OrderSplitter.class);

	@Override
	protected Object splitMessage(Message<?> message) {
	
//		log.debug("*** [OrderSplitter] ****");

		log.debug("*** [OrderSplitter] splitting Order into it's constituent OrderItems : number of OrderItems: "+ ((Order)message.getPayload()).getOrderItems().size() + " ****");

		return ((Order)message.getPayload()).getOrderItems();
	}

}
