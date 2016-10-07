package com.worldline.station.service;

import com.worldline.station.business.Station;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericlaheurte on 06/10/2016.
 */
@Service
public class StationService {
    private Station station;

    public List<Station> findAllStations() {
        Station station;
        List<Station> stations = new ArrayList<Station>();
        for (int i = 0; i < 5; i++) {
            station = new Station();
            stations.add(station);
        }
        return stations;
    }

    public Station findById(long id) {
        return new Station();
    }


}
