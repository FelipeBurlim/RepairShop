package com.github.felipeburlim.repairshop.api.model;

import com.github.felipeburlim.repairshop.api.dto.MechanicData;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mechanic {
    @Column(name = "mechanic_name")
    private String name;

    @Column(name = "mechanic_years_of_experience")
    private Integer yearsOfExperience;

    public Mechanic(MechanicData data) {
        this.name = data.name();
        this.yearsOfExperience = data.yearsOfExperience();
    }

    public void updateInformation(String name, Integer yearsOfExperience) {
        if (name != null) {
            this.name = name;
        }
        if (yearsOfExperience != null) {
            this.yearsOfExperience = yearsOfExperience;
        }
    }
}