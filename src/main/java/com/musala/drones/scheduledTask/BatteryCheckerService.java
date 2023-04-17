package com.musala.drones.scheduledTask;

import com.musala.drones.drone.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
public class BatteryCheckerService {

    private final DroneService droneService;
    @Scheduled(cron = "${cronexp}")
    public void execute() throws InterruptedException {


    }
}
