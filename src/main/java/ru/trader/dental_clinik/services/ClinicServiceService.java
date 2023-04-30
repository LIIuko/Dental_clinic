package ru.trader.dental_clinik.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trader.dental_clinik.models.ClinicService;
import ru.trader.dental_clinik.repositories.ClinicServiceRepository;

import java.util.List;

@Service
public class ClinicServiceService {
    @Autowired
    ClinicServiceRepository clinicServiceRepository;

    @Transactional
    public void addClinicService(ClinicService clinicService){
        clinicServiceRepository.save(clinicService);
    }

    @Transactional
    public void deleteClinicServiceById(Long id){
        clinicServiceRepository.deleteById(id);
    }

    @Transactional
    public List<ClinicService> getAllClinicServices(){
        return clinicServiceRepository.findAll();
    }

    @Transactional
    public ClinicService getClinicServiceById(Long id){
        return clinicServiceRepository.findById(id).orElse(null);
    }

    @Transactional
    public void updateClinicService(ClinicService clinicService){
        clinicServiceRepository.flush();
    }
}
