package com.musala.drones.mapper;

import com.musala.drones.drone.Drone;
import com.musala.drones.drone.dto.DroneDTO;
import com.musala.drones.medication.Medication;
import com.musala.drones.medication.dto.MedicationDTO;

import java.util.Set;

@org.mapstruct.Mapper
public interface Mapper {
    Drone toDroneDto(DroneDTO droneDTO);
    DroneDTO toDrone(Drone drone);
    MedicationDTO toMedication(Medication medication);
    Medication toMedicationDto(MedicationDTO medicationDTO);
    Set<Medication> toMedicationDTOSet(Set<MedicationDTO> medicationDTOSet);
    Set<MedicationDTO> toMedicationSet(Set<Medication> medicationSet);

}
