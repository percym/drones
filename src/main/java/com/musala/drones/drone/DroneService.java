package com.musala.drones.drone;

import java.util.List;

/**
 * The interface for the service
 * @author percym
 */
public interface DroneService {

    Drone save(Drone drone);
    List<Drone> getAll();
}
