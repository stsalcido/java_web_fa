package com.ssal.jfs5_java_web_assessment.controller;

import com.ssal.jfs5_java_web_assessment.model.Motorcycle;
import com.ssal.jfs5_java_web_assessment.model.MotorcycleDTO;
import com.ssal.jfs5_java_web_assessment.service.MotorcycleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/motorcycles")
public class MotorcycleController {
    private final MotorcycleService motorcycleService;

    public MotorcycleController(MotorcycleService service) {
        motorcycleService = service;
    }

    @GetMapping
    public List<Motorcycle> getAllMotorcycles() {
        return motorcycleService.getAllMotorcycles();
    }

    @PostMapping
    public void saveMotorcycle(@RequestBody MotorcycleDTO motorcycle) {
        motorcycleService.addMotorcycle(motorcycle);
    }

    @PutMapping
    public void putMotorcycle(@RequestBody Motorcycle motorcycle) {
        motorcycleService.putMotorcycle(motorcycle);
    }

    @PutMapping("/{id}")
    public void putMotorcycle(@RequestBody MotorcycleDTO motorcycle, @PathVariable Long id) {
        motorcycleService.putMotorcycle(motorcycle, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        motorcycleService.deleteMotorcycle(id);
    }
}
