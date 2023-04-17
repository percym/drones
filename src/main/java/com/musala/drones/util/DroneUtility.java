package com.musala.drones.util;

import com.musala.drones.drone.Drone;
import com.musala.drones.drone.dto.DroneDTO;
import com.musala.drones.enums.DroneState;
import com.musala.drones.exceptions.CustomException;
import com.musala.drones.medication.Medication;
import lombok.experimental.UtilityClass;

import java.util.concurrent.atomic.AtomicInteger;

@UtilityClass
public class DroneUtility {

    public static boolean checkBattery(DroneDTO droneDTO){
        if (droneDTO.getBatteryCapacity() < 25 && (droneDTO.getState()== DroneState.LOADING)){
            throw  new CustomException("Drone Battery is less than 25 % please recharge ");
        }
        return true;
    }

    public static boolean checkDroneWeight(Drone drone, Medication medication){
        AtomicInteger medicineWeight =  new AtomicInteger(0);
        drone.getMedication().forEach(medic -> {
            medicineWeight.getAndAdd(medic.getWeight());
        });
        medicineWeight.getAndAdd(medication.getWeight());
        return medicineWeight.get() < 500;
    }
}
