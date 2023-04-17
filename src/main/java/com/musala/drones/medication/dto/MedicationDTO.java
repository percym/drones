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
    @Column(name = "medication_code")
    private String code;

    @Lob
    @Column(name = "medication_image", columnDefinition="BLOB")
    private byte[] image;

    @Column(name = "battery_capacity")
    private Integer batteryCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "drone_state",  nullable = false)
    private DroneState state;
}
