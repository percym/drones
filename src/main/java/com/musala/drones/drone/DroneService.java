package com.musala.drones.drone;

import java.util.List;
import java.util.Optional;

/**
 * The interface for the service
 * @author percym
 */
public interface DroneService {

    Drone save(Drone drone);

    List<Drone> findAll();

    Optional<Drone> findById(Long droneId);
}
