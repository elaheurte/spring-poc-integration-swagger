package com.worldline.station.service;

import com.worldline.station.business.Diesel;
import com.worldline.station.business.LeadedPetrol;
import com.worldline.station.business.OrderItem;
import com.worldline.station.business.UnleadedPetrol;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

/**
 * Class invoked by ServiceActivator
 * Performs the unitPrice reductions for all item types.
 * @author ericlaheurte
 *
 */
public class Shopkeeper {

	private static final Logger log = Logger.getLogger(Shopkeeper.class);

	private static final BigDecimal DIESEL_UNIT_PRICE = new BigDecimal(0.05);
	private static final BigDecimal LEADED_PETROL_UNIT_PRICE = new BigDecimal(0.10);
	private static final BigDecimal UNLEADED_PETROL_UNIT_PRICE = new BigDecimal(0.15);


	public OrderItem processDiesel(OrderItem dieselOrderItem) {
		log.debug("*** [Shopkeeper] processing book : " + dieselOrderItem.getProduct().getClass() + " ****");

		final BigDecimal finalPrice = calculateDiscountedPrice(dieselOrderItem, DIESEL_UNIT_PRICE);

		return dieselOrderItem;
	}

	public OrderItem processLeadedPetrol(OrderItem leadedPetrolOrderItem) {
		log.debug("*** [Shopkeeper] processing music : " + leadedPetrolOrderItem.getProduct().getClass() + " ****");

		final BigDecimal finalPrice = calculateDiscountedPrice(leadedPetrolOrderItem, LEADED_PETROL_UNIT_PRICE);

		return leadedPetrolOrderItem;
	}


	public OrderItem processUnLeadedPetrol(OrderItem unleadedPetrolOrderItem) {
		log.debug("*** [Shopkeeper] processing software : " + unleadedPetrolOrderItem.getProduct().getClass() + " ****");

		final BigDecimal finalPrice = calculateDiscountedPrice(unleadedPetrolOrderItem, UNLEADED_PETROL_UNIT_PRICE);

		return unleadedPetrolOrderItem;
	}

	/*
	 * Computes the new discounted unitPrice for an item
	 * @param orderItem the item of interest
	 * @param discount The amount to be discounted.
	 */
	private BigDecimal calculateDiscountedPrice(final OrderItem orderItem, final BigDecimal discount) {

		final BigDecimal discountedPrice =round(orderItem.getTotalPrice().multiply(discount));
		final BigDecimal finalPrice = round(orderItem.getTotalPrice().subtract(discountedPrice));

		log.debug("item (" + getItemType(orderItem) + ") " +
				"item unitPrice: " + orderItem.getProduct().getUnitPrice() +
				" discount: " + discountedPrice +
				" final unitPrice: " + finalPrice);

		return finalPrice;
	}

	private String getItemType(final OrderItem orderItem) {

		String type = "";

		if (orderItem.getProduct() instanceof UnleadedPetrol) {
			type = "UnleadedPetrol: " + orderItem.getProduct().getClass();
		} else if (orderItem.getProduct() instanceof Diesel) {
			type = "Diesel: " + orderItem.getProduct().getClass();
		} else if (orderItem.getProduct() instanceof LeadedPetrol) {
			type = "LeadedPetrol: " + orderItem.getProduct().getClass();
		}

		return type;
	}
	
	/**
	 * Round for currency values
	 * @param value
	 * @return
	 */
	private BigDecimal round(final BigDecimal value) {
		return value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

}
