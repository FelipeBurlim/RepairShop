package com.github.felipeburlim.repairshop.api.model;

import com.github.felipeburlim.repairshop.api.dto.VehicleData;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Column(name = "vehicle_make")
    private String make;

    @Column(name = "vehicle_model")
    private String model;

    @Column(name = "vehicle_year")
    private String year;

    @Column(name = "vehicle_color")
    private String color;

    public Vehicle(VehicleData data) {
        this.make = data.make();
        this.model = data.model();
        this.year = data.year();
        this.color = data.color();
    }
}