package com.musala.drones.scheduledTask;

import com.musala.drones.battery.BatteryChecker;
import com.musala.drones.battery.BatteryCheckerService;
import com.musala.drones.drone.Drone;
import com.musala.drones.drone.DroneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class BatteryCheckerTask {

    private final DroneService droneService;
    private final BatteryCheckerService batteryCheckerService;
    @Scheduled(cron = "${cronexp}")
    public void execute() throws InterruptedException {

        List<Drone>  droneList = droneService.findAll();
        droneList.forEach(drone -> {
            BatteryChecker batteryChecker = new BatteryChecker();
            batteryChecker.setDroneSerial(drone.getSerialNumber());
            batteryChecker.setBatteryPercentage(drone.getBatteryCapacity());
            batteryChecker= batteryCheckerService.save(batteryChecker);
            log.info("checked battery {}", batteryChecker);
        });


    }
}
