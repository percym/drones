package com.musala.drones.battery;

import com.musala.drones.base.BaseEntityAudit;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "battery_checker")
@Data
public class BatteryChecker extends BaseEntityAudit {

    @NotEmpty
    @Column(name = "drone_serial")
    private String droneSerial;

    @NotNull
    @Column(name = "battery_percentage")
    private Integer batteryPercentage;

}
