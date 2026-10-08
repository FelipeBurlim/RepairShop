package com.github.felipeburlim.repairshop.api.repository;

import com.github.felipeburlim.repairshop.api.model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RepairRepository extends JpaRepository<Repair, Long> {
    List<Repair> findAllByActiveTrue();
}