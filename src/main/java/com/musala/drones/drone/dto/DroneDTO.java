package com.musala.drones.drone.dto;

import com.musala.drones.enums.DroneModel;
import com.musala.drones.enums.DroneState;
import com.musala.drones.medication.dto.MedicationDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class DroneDTO {

    private Long id;

    @NotEmpty
    @Size(max = 100)
    private String serialNumber;

    @NotNull
    private DroneModel model;

    @NotNull
    private Integer weight;

    @NotNull
    private Integer batteryCapacity;

    @NotNull
    private DroneState state;

    private Set<MedicationDTO> medication;
}
