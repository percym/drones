package com.musala.drones.dispatch;

import com.musala.drones.drone.Drone;
import com.musala.drones.drone.DroneService;
import com.musala.drones.drone.dto.DroneDTO;
import com.musala.drones.exceptions.CustomException;
import com.musala.drones.mappers.Mapper;
import com.musala.drones.medication.Medication;
import com.musala.drones.medication.MedicationService;
import com.musala.drones.medication.dto.MedicationDTO;
import com.musala.drones.util.DroneUtility;
import com.musala.drones.util.MedicineUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    /**
     *Method to add individual drone to database
     * Drone medication is cleared and current carry weight  to zero sam with id since it's a new drone
     *
     * @param  droneDTO  an absolute URL giving the base location of the image
     * @return    Drone JSON object  with status 200 if saved ok
     */
    @PostMapping("/add-drone")
    public ResponseEntity<Drone> addDrone(@RequestBody  DroneDTO droneDTO) {
        Drone drone =mapper.map(droneDTO,Drone.class);
        drone.setId(0L);
        drone.setWeight(0);
        drone.getMedication().clear();
        log.info("{}",drone);
        return new ResponseEntity<>(droneService.save(drone), null, HttpStatus.OK);
    }

    /**
     *Method to list all  drones in database
     *
     * @return    {Link Medication}  JSON list object with medication if loaded json with status 200 if saved ok
     */
    @GetMapping("/get-all-drones")
    public ResponseEntity<List<DroneDTO>> getAllDrones() {
        List<Drone> droneList = droneService.findAll();
        List<DroneDTO> droneDTOList = new ArrayList<DroneDTO>();
        droneDTOList = mapper.map(droneList, new TypeToken<List<DroneDTO>>() {}.getType());
        log.info(" all drones{}",droneDTOList);
        return new ResponseEntity<>(droneDTOList, null, HttpStatus.OK);
    }



    /**
     *Method to update drone details
     *
     * @param  droneDTO  an absolute URL giving the base location of the image
     * @return    Drone JSON object  with status 200 if saved ok
     */
    @PutMapping("/update-drone")
    public ResponseEntity<Drone> updateDrone(@RequestBody  DroneDTO droneDTO) {
        Optional<Drone> currentDrone = droneService.findById(droneDTO.getId());
        Drone drone = new Drone();
        if (currentDrone.isPresent()) {
            if (DroneUtility.checkBattery(droneDTO))
            drone = mapper.map(droneDTO, Drone.class);
            log.info("{}", drone);
            return new ResponseEntity<>(droneService.save(drone), null, HttpStatus.OK);
        }

        return new ResponseEntity<>(drone, null, HttpStatus.BAD_REQUEST);
    }

    /**
     *Method to add  a single medication item to database
     * @param medicationDTO with the valid medication specs
     *Medication Id is set to zero since its new
     * @return    {Link Medication } JSON object with medication if loaded json with status 200 if saved ok
     */
    @PostMapping("/add-medication")
    public ResponseEntity<Medication> addMedication(@RequestBody MedicationDTO medicationDTO) {
        Medication medication = mapper.map(medicationDTO,Medication.class);
        medication.setId(0L);
        log.info(" add medication {}",medication);
        if (MedicineUtil.checkHasSpecialCharacter(medication.getName())){
            throw new CustomException("Invalid medicine name has special characters");
        }

        if (MedicineUtil.checkHasSpecialCharacter(medication.getCode()) ){
            throw new CustomException("Invalid medicine code has special characters");
        }

        if (MedicineUtil.checkHasNumbers(medication.getCode()) ){
            throw new CustomException("Invalid medicine code has numbers");
        }
        return new ResponseEntity<>(medicationService.save(medication), null, HttpStatus.OK);
    }


    /**
     *Method to list all  medications in database
     *
     * @return    {Link MedicationDTO} JSON list  object with medication if loaded json with status 200 if saved ok
     */
    @GetMapping("/get-all-medicine")
    public ResponseEntity<List<MedicationDTO>> getAllMedicine() {

        List<Medication> medications = medicationService.findAll();
        List<MedicationDTO> medicationDTOS = new ArrayList<>();
        medicationDTOS = mapper.map(medications, new TypeToken<List<MedicationDTO>>() {}.getType());
        log.info(" all medication {}",medicationDTOS);
        return new ResponseEntity<>(medicationDTOS, null, HttpStatus.OK);
    }

    /**
     *Method to add medication to drone in {Link DroneStatus.Loading or DroneStatus.Idle} and battery above 25% drone will be
     * set to status loading a weight check will be conducted to ensure current medicine + existing
     * does not exceed 500gr
     * @param droneId the drone to be loaded
     * @param medicineId the id of medicine to be loaded
     * @return    {Link MedicationDTO} JSON list  object with medication if loaded json with status 200 if saved ok
     */
    @GetMapping("/load-drone/{droneId}/{medicineId}")
    public ResponseEntity<Drone> loadDrone(@PathVariable Long droneId, @PathVariable Long medicineId) {
        Optional<Drone> currentDrone = droneService.findById(droneId);
        if (!currentDrone.isPresent()){
            throw new CustomException("Invalid Drone ");
        }
        Optional<Medication> currentMedication = medicationService.findById(medicineId);
        if(!currentMedication.isPresent()){
            throw new CustomException("Invalid Medication ");
        }
        if (!DroneUtility.checkDroneWeight(currentDrone.get(), currentMedication.get())){
            throw new CustomException("Drone Overloaded ");
        }
        Drone droneToAdd = currentDrone.get();
        droneToAdd.getMedication().add(currentMedication.get());
        droneToAdd.setWeight(droneToAdd.getWeight() + droneToAdd.getWeight());

        log.info(" loaded drone with medication {}",droneToAdd);
        return new ResponseEntity<>(droneService.save(droneToAdd), null, HttpStatus.OK);
    }
}
