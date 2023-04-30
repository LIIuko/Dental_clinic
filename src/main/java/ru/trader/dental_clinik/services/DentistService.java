package ru.trader.dental_clinik.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trader.dental_clinik.models.Dentist;
import ru.trader.dental_clinik.repositories.DentistRepository;

import java.util.List;

@Service
public class DentistService {
    @Autowired
    DentistRepository dentistRepository;

    @Transactional
    public void addDentist(Dentist dentist){
        dentistRepository.save(dentist);
    }

    @Transactional
    public void deleteDentist(Dentist dentist){
        dentistRepository.delete(dentist);
    }

    @Transactional
    public void deleteDentistById(Long id){
        dentistRepository.deleteById(id);
    }

    @Transactional
    public List<Dentist> getAllDentists(){
        return dentistRepository.findAll();
    }

    @Transactional
    public Dentist getDentistById(Long id){
        return dentistRepository.findById(id).orElse(null);
    }

    @Transactional
    public void updateDentist(Dentist dentist){
        dentistRepository.flush();
    }
}
