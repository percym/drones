package com.musala.drones.drone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The repository for the {@link Drone} entity
 *
 * @author percym
 */
@Repository
public interface DroneRepository extends JpaRepository<Drone,Long> {

    Drone save(Drone Drone);

    List<Drone> getAll();
}
