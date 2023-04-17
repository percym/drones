package com.musala.drones.battery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryRepository  extends JpaRepository<BatteryChecker, Long> {

    BatteryChecker save(BatteryChecker batteryChecker);
}
