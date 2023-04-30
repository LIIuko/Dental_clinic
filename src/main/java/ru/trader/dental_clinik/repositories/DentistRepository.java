package ru.trader.dental_clinik.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trader.dental_clinik.models.Dentist;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
