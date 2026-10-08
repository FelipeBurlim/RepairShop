package com.github.felipeburlim.repairshop.api.dto;

import com.github.felipeburlim.repairshop.api.model.Mechanic;
import com.github.felipeburlim.repairshop.api.model.Repair;
import com.github.felipeburlim.repairshop.api.model.Vehicle;

public record RepairDetailsData(
        Long id,
        String entryDate,
        String exitDate,
        Mechanic mechanic,
        Vehicle vehicle,
        Boolean active
) {
    public RepairDetailsData(Repair repair) {
        this(
                repair.getId(),
                repair.getEntryDate(),
                repair.getExitDate(),
                repair.getMechanic(),
                repair.getVehicle(),
                repair.getActive()
        );
    }
}