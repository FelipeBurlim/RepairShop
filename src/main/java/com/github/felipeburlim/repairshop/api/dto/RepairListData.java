package com.github.felipeburlim.repairshop.api.dto;

import com.github.felipeburlim.repairshop.api.model.Repair;

public record RepairListData(
        Long id,
        String entryDate,
        String exitDate,
        String mechanicName,
        String vehicleMake,
        String vehicleModel
) {
    public RepairListData(Repair repair) {
        this(
                repair.getId(),
                repair.getEntryDate(),
                repair.getExitDate(),
                repair.getMechanic().getName(),
                repair.getVehicle().getMake(),
                repair.getVehicle().getModel()
        );
    }
}