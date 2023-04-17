package com.musala.drones.medication.dto;

import com.musala.drones.enums.DroneState;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class MedicationDTO {

    private  Long id;

    @NotEmpty
    private String name;

    @NotNull
    private Integer weight;

    @NotEmpty
    private String code;

    @NotEmpty
    private String image;


    @NotNull
    private Integer batteryCapacity;

    @NotNull
    private DroneState state;
}
