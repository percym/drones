package com.musala.drones.medication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicationRepository extends JpaRepository<Medication,Long> {

    Medication save(Medication medication);

    List<Medication> findAll();

    Optional<Medication> findById(Long medicationId);
}
