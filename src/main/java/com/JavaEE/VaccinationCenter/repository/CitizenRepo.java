package com.JavaEE.VaccinationCenter.repository;

import com.JavaEE.VaccinationCenter.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CitizenRepo extends JpaRepository<Citizen, Long> {

    public List<Citizen> findAllByCenter_Id(Long id);
}
