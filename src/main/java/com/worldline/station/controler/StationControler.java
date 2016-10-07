package com.worldline.station.controler;

import com.worldline.station.business.Station;
import com.worldline.station.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ericlaheurte on 06/10/2016.
 */
@RestController
public class StationControler {

    @Autowired
    StationService stationService;

    @Autowired
    @Qualifier("quakeinfo.channel")
    PollableChannel quakeinfoChannel;

    @RequestMapping(value = "/stations/", method = RequestMethod.GET)
    public ResponseEntity<List<Station>> listAllUsers() {
        List<Station> stations = stationService.findAllStations();
        if (stations.isEmpty()) {
            return new ResponseEntity<List<Station>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Station>>(stations, HttpStatus.OK);
    }

    @RequestMapping(value = "/stations/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Station> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching Station with id " + id);
        Station station = stationService.findById(id);
        if (station == null) {
            System.out.println("Station with id " + id + " not found");
            return new ResponseEntity<Station>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Station>(station, HttpStatus.OK);
    }

    @RequestMapping(value = "/stations/polling", method = RequestMethod.GET)
    public ResponseEntity<Message> polling() {
        Message<?> message = quakeinfoChannel.receive();
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }
}
