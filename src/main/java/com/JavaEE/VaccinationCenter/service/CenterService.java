package com.JavaEE.VaccinationCenter.service;

import com.JavaEE.VaccinationCenter.model.Center;
import com.JavaEE.VaccinationCenter.repository.CenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CenterService {
    @Autowired
    private CenterRepo centerRepo;

    public List<Center> findAll(){
        return centerRepo.findAll();
    }
    public void saveCenter(Center center) {
        centerRepo.save(center);
    }

    public void deleteCenter(Long id){
        centerRepo.deleteById(id);
    }
}
