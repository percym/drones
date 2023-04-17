package com.musala.drones.drone;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * The implementation for the {@Link DroneService} service
 * @author percym
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DroneServiceImpl  implements DroneService{

    private final DroneRepository droneRepository;

    @Transactional
    @Override
    public Drone save(Drone drone) {
        return droneRepository.save(drone);
    }
}
