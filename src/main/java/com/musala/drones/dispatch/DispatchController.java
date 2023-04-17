package com.musala.drones.dispatch;

import com.musala.drones.drone.Drone;
import com.musala.drones.drone.DroneService;
import com.musala.drones.drone.dto.DroneDTO;
import com.musala.drones.mappers.Mapper;
import com.musala.drones.medication.MedicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    private final ModelMapper mapper;

    @PostMapping("/add-drone")
    public ResponseEntity<Drone> addDrone(@RequestBody  DroneDTO droneDTO) {
        Drone drone =mapper.map(droneDTO,Drone.class);
        log.info("{}",drone);
        return new ResponseEntity<>(droneService.save(drone), null, HttpStatus.OK);
    }

    @GetMapping("/get-all-drones")
    public ResponseEntity<List<Drone>> addDrone() {
        List<Drone> droneList = droneService.getAll();
        List<DroneDTO> droneDTOList = new ArrayList<DroneDTO>();
        droneDTOList = mapper.map(droneList, new TypeToken<List<DroneDTO>>() {}.getType());
        log.info(" all drones{}",droneDTOList);
        return new ResponseEntity<>(droneList, null, HttpStatus.OK);
    }
}
