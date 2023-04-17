package com.musala.drones.medication;

import com.musala.drones.base.BaseEntity;
import com.musala.drones.enums.DroneState;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name ="medication")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Medication extends BaseEntity {

    @NotEmpty
    @Column(name = "medication_name")
    private String name;

    @NotEmpty
    @Column(name = "medication_weight")
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