package com.musala.drones.drone;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Drone> findAll() {
        return droneRepository.findAll();
    }

    @Override
    public Optional<Drone> findById(Long droneId) {
        return droneRepository.findById(droneId);
    }
}
