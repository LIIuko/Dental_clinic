package ru.trader.dental_clinik.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.trader.dental_clinik.models.ClinicService;
import ru.trader.dental_clinik.models.Dentist;
import ru.trader.dental_clinik.services.ClinicServiceService;
import ru.trader.dental_clinik.services.DentistService;

import java.util.List;

@Controller
@RequestMapping("dentist")
public class DentistController {
    @Autowired
    DentistService dentistService;
    @Autowired
    ClinicServiceService clinicServiceService;

    @RequestMapping
    public String showHome(Model model) {
        model.addAttribute("dentists", dentistService.getAllDentists());
        model.addAttribute("services", clinicServiceService.getAllClinicServices());
        return "dentist/dentist";
    }

    @PostMapping("add")
    public String createDentist(@ModelAttribute("dentist") Dentist dentist, Model model) {
        dentistService.addDentist(dentist);
        model.addAttribute("dentists", dentistService.getAllDentists());
        model.addAttribute("services", clinicServiceService.getAllClinicServices());
        return "dentist/dentist";
    }

    @GetMapping("{id}")
    public String dentistInfo(@PathVariable Long id, Model model) {
        model.addAttribute("dentist", dentistService.getDentistById(id));
        return "dentist/dentist-info";
    }

    @PostMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        dentistService.deleteDentistById(id);
        model.addAttribute("dentists", dentistService.getAllDentists());
        return "dentist/all__dentists";
    }

    @RequestMapping("show")
    public String showUsers(Model model) {
        List<Dentist> dentists = dentistService.getAllDentists();
        model.addAttribute("dentists", dentists);
        return "dentist/all__dentists";
    }
}
