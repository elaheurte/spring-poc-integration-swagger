package com.worldline.station.endpoint;

import com.worldline.station.business.Station;
import com.worldline.station.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by ericlaheurte on 04/10/2016.
 */
@Component
public class OrderInfoEndpoint {
    private static final String STATUSCODE_HEADER = "http_statusCode";

    @Autowired
    private StationService service;

    public Message<?> get(Message<String> msg) {
        long id = Long.valueOf(msg.getPayload());
        Station person = service.findById(id);

        if (person == null) {
            return MessageBuilder.fromMessage(msg)
                    .copyHeadersIfAbsent(msg.getHeaders())
                    .setHeader(STATUSCODE_HEADER, HttpStatus.NOT_FOUND)
                    .build();
        }

        return MessageBuilder.withPayload(person)
                .copyHeadersIfAbsent(msg.getHeaders())
                .setHeader(STATUSCODE_HEADER, HttpStatus.OK)
                .build();
    }
}
