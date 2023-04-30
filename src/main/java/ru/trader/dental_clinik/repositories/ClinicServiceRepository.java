package ru.trader.dental_clinik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trader.dental_clinik.models.ClinicService;

public interface ClinicServiceRepository extends JpaRepository<ClinicService, Long> {
}
