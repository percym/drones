package com.musala.drones;

import com.musala.drones.base.BaseEntity;
import com.musala.drones.enums.DroneModel;
import com.musala.drones.enums.DroneState;
import com.musala.drones.medication.Medication;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@Table(name ="drone")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Drone extends BaseEntity {

    @NotEmpty
    @Size(max = 100)
    @Column(name = "drone_serial_number", length = 100)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "drone_Model",  nullable = false)
    private DroneModel model;

    @Column(name = "drone_weight")
    private Integer weight;

    @Column(name = "drone_battery_capacity")
    private Integer batteryCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "drone_state",  nullable = false)
    private DroneState state;

    @OneToMany
    private Set<Medication> medication;
}
