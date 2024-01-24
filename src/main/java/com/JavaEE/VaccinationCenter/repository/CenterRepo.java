package com.JavaEE.VaccinationCenter.repository;

import com.JavaEE.VaccinationCenter.model.Center;
import com.JavaEE.VaccinationCenter.model.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CenterRepo extends JpaRepository<Center,Long> {
}
