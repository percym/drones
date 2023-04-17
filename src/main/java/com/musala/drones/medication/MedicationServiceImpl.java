package com.musala.drones.medication;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;

    @Transactional
    @Override
    public Medication save(Medication medication) {
        return medicationRepository.save(medication);
    }

    @Override
    public List<Medication> findAll() {
        return medicationRepository.findAll();
    }

    @Override
    public Optional<Medication> findById(Long medicationId) {
        return medicationRepository.findById(medicationId);
    }
}
