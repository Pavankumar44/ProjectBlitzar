package com.app.registration.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.registration.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
	
    Optional<Hospital> findById(Long id);
	
	Hospital findByHospitalName(String hospitalName);


}
