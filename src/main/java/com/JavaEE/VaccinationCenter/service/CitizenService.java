package com.JavaEE.VaccinationCenter.service;

import com.JavaEE.VaccinationCenter.model.Citizen;
import com.JavaEE.VaccinationCenter.repository.CitizenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenService {
    @Autowired
    private CitizenRepo citizenRepo;

    public List<Citizen> findAll(){
        return citizenRepo.findAll();
    }
    public void saveCitizen(Citizen citizen) {
        citizenRepo.save(citizen);
    }
    public List<Citizen> getAllCitizenByCenterId(Long id){
        return citizenRepo.findAllByCenter_Id(id);
    }
    public void deleteCitizen(Long id){
        citizenRepo.deleteById(id);
    }
}
