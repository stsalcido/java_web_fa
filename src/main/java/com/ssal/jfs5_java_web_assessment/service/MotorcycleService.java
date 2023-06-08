package com.ssal.jfs5_java_web_assessment.service;

import com.ssal.jfs5_java_web_assessment.model.Motorcycle;
import com.ssal.jfs5_java_web_assessment.model.MotorcycleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleService {

    private final MotorcycleRepository repository;

    public MotorcycleService(MotorcycleRepository motorcycleRepository) {
        repository = motorcycleRepository;
    }

    public List<Motorcycle> getAllMotorcycles() {
        return repository.findAll();
    }

    public void addMotorcycle(MotorcycleDTO newMotorcycle) {
        Motorcycle motorcycleToAdd = new Motorcycle();

        motorcycleToAdd.setMake(newMotorcycle.make());
        motorcycleToAdd.setModel(newMotorcycle.model());
        motorcycleToAdd.setYear(newMotorcycle.year());

        repository.save(motorcycleToAdd);
    }

    public void putMotorcycle(Motorcycle putMotorcycle) {
        Long id = putMotorcycle.getId();
        Motorcycle foundMotorcycle = repository.findById(id).orElseThrow();
        foundMotorcycle.setModel(putMotorcycle.getModel());
        foundMotorcycle.setMake(putMotorcycle.getMake());
        foundMotorcycle.setYear(putMotorcycle.getYear());
        repository.save(foundMotorcycle);
    }

    public void deleteMotorcycle(Long id){
        repository.deleteById(id);
    }

    public void putMotorcycle(MotorcycleDTO motorcycle, Long id) {
        Motorcycle foundMotorcycle = repository.findById(id).orElseThrow();

        foundMotorcycle.setModel(motorcycle.model());
        foundMotorcycle.setMake(motorcycle.make());
        foundMotorcycle.setYear(motorcycle.year());

        repository.save(foundMotorcycle);
    }
}
