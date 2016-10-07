package com.worldline.station.controler;

import com.worldline.station.business.*;
import com.worldline.station.service.ShopStation;
import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericlaheurte on 04/10/2016.
 */
@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private static final Logger log = Logger.getLogger(OrderController.class);

    //@Autowired
    //private ApplicationContext context;

    /*
 * Create a dummy order
 */
    private static Order createOrder() {
        UnleadedPetrol unleadedPetrol = new UnleadedPetrol(new BigDecimal("1.55"));
        Diesel diesel = new Diesel(new BigDecimal("1.15"));
        LeadedPetrol leadedPetrol = new LeadedPetrol(new BigDecimal("1.35"));

        OrderItem unleadedPetrolItems = new OrderItem(unleadedPetrol);
        unleadedPetrolItems.setQuantity(60);

        OrderItem dieselItems = new OrderItem(diesel);
        dieselItems.setQuantity(120);

        OrderItem leadedPetrolItems = new OrderItem(leadedPetrol);
        leadedPetrolItems.setQuantity(40);

        final List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(unleadedPetrolItems);
        orderItems.add(dieselItems);
        orderItems.add(leadedPetrolItems);

        Order order = new Order();
        order.setOrderItems(orderItems);
        log.debug("Order: " + order);
//		log.debug("Total : "+ order.getTotalCost());

        return order;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Order addOrder() {
        //Get hold of spring context 
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("station.xml");

        ShopStation shop = (ShopStation) context.getBean("shop");

        Order order = createOrder();
        shop.placeOrder(order);

        return order;
        //context.close();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<OrderItem> getOrder() {

        Order order = createOrder();

        return order.getOrderItems();
        //context.close();
    }

}
