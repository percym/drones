package com.musala.drones.drone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The repository for the {@link Drone} entity
 *
 * @author percym
 */
@Repository
public interface DroneRepository extends JpaRepository<Drone,Long> {

    Drone save(Drone Drone);
}
