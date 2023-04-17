package com.musala.drones.util;

import com.musala.drones.drone.dto.DroneDTO;
import com.musala.drones.enums.DroneState;
import com.musala.drones.exceptions.CustomException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DroneUtility {

    private static boolean checkBattery(DroneDTO droneDTO){
        if (droneDTO.getBatteryCapacity() < 25 && (droneDTO.getState()== DroneState.LOADING)){
            throw  new CustomException("Drone Battery is less than 25 % please recharge ");
        }
        return true;
    }
}
