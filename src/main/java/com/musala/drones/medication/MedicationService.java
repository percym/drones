package com.musala.drones.medication;

import java.util.List;
import java.util.Optional;

public interface MedicationService {

    Medication save(Medication medication);

    List<Medication> findAll();

    Optional<Medication> findById(Long medicationId);
}
