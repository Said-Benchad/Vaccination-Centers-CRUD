package com.JavaEE.VaccinationCenter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String centerName;
    private String address;
    @OneToMany(mappedBy = "center", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Citizen> citizens = new ArrayList<>();


    public void addCitizen(Citizen citizen) {
        citizens.add(citizen);
        citizen.setCenter(this);
    }

    public void removeCitizen(Citizen citizen) {
        citizens.remove(citizen);
        citizen.setCenter(null);
    }

}
