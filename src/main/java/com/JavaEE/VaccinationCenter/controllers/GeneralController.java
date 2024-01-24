package com.JavaEE.VaccinationCenter.controllers;

import com.JavaEE.VaccinationCenter.model.Center;
import com.JavaEE.VaccinationCenter.model.Citizen;
import com.JavaEE.VaccinationCenter.service.CenterService;
import com.JavaEE.VaccinationCenter.service.CitizenService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class GeneralController {
    @Autowired
    private CenterService centerService;
    @Autowired
    private CitizenService citizenService;

    // Affichage index.html
    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }
    // Affichage about.html
    @GetMapping("/about")
    public String viewAboutPage() {
        return "about";
    }



// ############ Center #############
    //Affichage des centres de vaccination
    @GetMapping("/centers")
    public String getAllCenters(Model model) {
        List<Center> centerList = centerService.findAll();
        if(centerList.size()>0) {
            model.addAttribute("centerList", centerList);
        }
        return "centers";
    }
// Affichage le formulaire de centre
    @GetMapping("/add-center")
    public String addCenter(Model model) {
        model.addAttribute("center", new Center());
        return "centerForm";
    }
    // Sauvgarger centre
    @PostMapping("/save-center")
    public String saveCenter(Center center) {
        centerService.saveCenter(center);
        return "redirect:/centers";
    }
    // Supprimer centre
    @GetMapping("/deleteCenter/{id}")
    public String deleteCenter(@PathVariable Long id, Model model){
        centerService.deleteCenter(id);
        System.out.print("Id Center: "+ id);
        List<Center> centerList = centerService.findAll();
        if(centerList.size()>0) {
            model.addAttribute("centerList", centerList);
        }
        return "centers";

    }
    // ########### Centre ###########

    // ########### CITIZENS ###########

    @GetMapping("/citizens")
    public String getAllCitizens(Model model) {

        List<Citizen> citizenList = citizenService.findAll();
        if(citizenList.size()>0) {
            model.addAttribute("citizenList", citizenList);
        }
        return "citizens";
    }

    @GetMapping("/citizen-form")
    public String getCitizenForm(Model model) {
        model.addAttribute("citizen", new Citizen());
        List<Center> centerList = centerService.findAll();
        if(centerList.size()>0) {
            model.addAttribute("centerList", centerList);
        }
        return "citizenForm";
    }


    @PostMapping("/save-citizen")
    public String saveCitizen(@ModelAttribute Citizen citizen) {

        citizenService.saveCitizen(citizen);
        return "redirect:/citizens";
    }

    @GetMapping("/deleteCitizen/{id}")
    public String deleteCitizen(@PathVariable Long id, Model model){
        citizenService.deleteCitizen(id);
        List<Citizen> citizenList = citizenService.findAll();
        if(citizenList.size()>0) {
            model.addAttribute("citizenList", citizenList);
        }
        return "citizens";

    }
// ########### CITIZENS ###########

// ##########  listCenters #########
@GetMapping("/listCenters")
public String getListCenters(Model model) {
    List<Center> centerList = centerService.findAll();
    List<Citizen> citizenList = citizenService.findAll();
    for (Center center:centerList) {
        List<Citizen> tmpCitizens = citizenService.getAllCitizenByCenterId(center.getId());
        center.setCitizens(tmpCitizens);
    }
    if(citizenList.size()>0 && centerList.size()>0) {
        model.addAttribute("citizenList", citizenList);
        model.addAttribute("centerList", centerList);

    }

    return "listCenters";
}

}
