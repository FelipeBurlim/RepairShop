package com.github.felipeburlim.repairshop.api.model;

import com.github.felipeburlim.repairshop.api.dto.CreateRepairData;
import com.github.felipeburlim.repairshop.api.dto.UpdateRepairData;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "repairs")
@Entity(name = "Repair")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entryDate;
    private String exitDate;

    @Embedded
    private Mechanic mechanic;

    @Embedded
    private Vehicle vehicle;

    private Boolean active;

    public Repair(CreateRepairData data) {
        this.active = true;
        this.entryDate = data.entryDate();
        this.exitDate = data.exitDate();
        this.mechanic = new Mechanic(data.mechanic());
        this.vehicle = new Vehicle(data.vehicle());
    }

    public void updateInformation(UpdateRepairData data) {
        if (data.exitDate() != null) {
            this.exitDate = data.exitDate();
        }
        if (this.mechanic != null) {
            this.mechanic.updateInformation(data.mechanicName(), data.mechanicYearsOfExperience());
        }
    }

    public void delete() {
        this.active = false;
    }
}