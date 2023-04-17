package com.musala.drones.battery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BatteryCheckerServiceImpl implements BatteryCheckerService{
    private final BatteryRepository batteryRepository;
    @Override
    public BatteryChecker save(BatteryChecker batteryChecker) {
        return batteryRepository.save(batteryChecker);
    }
}
