package com.musala.drones.dispatch;

import com.musala.drones.drone.Drone;
import com.musala.drones.drone.DroneService;
import com.musala.drones.medication.MedicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller for dispatching drones
 *
 * @author percym
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/dispatch")
@RequiredArgsConstructor
public class DispatchController {
    private final DroneService droneService;
    private final MedicationService medicationService;


    @GetMapping("/add-drone")
    public ResponseEntity<Drone> addDrone(Drone drone) {
        return new ResponseEntity<>(droneService.save(drone), null, HttpStatus.OK);
    }

}
