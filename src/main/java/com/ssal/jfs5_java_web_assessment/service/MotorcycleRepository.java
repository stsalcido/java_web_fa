package com.ssal.jfs5_java_web_assessment.service;

import com.ssal.jfs5_java_web_assessment.model.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {

}
