package ru.trader.dental_clinik.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.trader.dental_clinik.models.ClinicService;
import ru.trader.dental_clinik.models.Dentist;
import ru.trader.dental_clinik.services.ClinicServiceService;

import java.util.List;

@Controller
@RequestMapping("service")
public class ClinicServiceController {

    @Autowired
    ClinicServiceService clinicServiceService;

    @RequestMapping
    public String showHome(Model model) {
        model.addAttribute("clinicServices", clinicServiceService.getAllClinicServices());
        return "clinicService/clinic__service";
    }

    @PostMapping("add")
    public String createDentist(ClinicService clinicService, Model model) {
        clinicServiceService.addClinicService(clinicService);
        model.addAttribute("clinicServices", clinicServiceService.getAllClinicServices());
        return "clinicService/clinic__service";
    }

    @GetMapping("{id}")
    public String dentistInfo(@PathVariable Long id, Model model) {
        model.addAttribute("clinicService", clinicServiceService.getClinicServiceById(id));
        return "clinicService/clinic__service-info";
    }

    @PostMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        clinicServiceService.deleteClinicServiceById(id);
        model.addAttribute("clinicServices", clinicServiceService.getAllClinicServices());
        return "clinicService/clinic__service";
    }

    @RequestMapping("show")
    public String showUsers(Model model) {
        List<ClinicService> clinicServices = clinicServiceService.getAllClinicServices();
        model.addAttribute("clinicServices", clinicServices);
        return "clinicService/clinic__service";
    }
}
