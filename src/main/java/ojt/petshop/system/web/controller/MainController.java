package ojt.petshop.system.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ojt.petshop.system.bl.service.PetService;
import ojt.petshop.system.persistence.entity.Pet;

@Controller
public class MainController {
    @Autowired
    private PetService petService;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView petList(ModelAndView model) {
        List<Pet> petList = petService.doGetList();
        model.addObject("petList", petList);
        model.setViewName("view");
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView newPet(ModelAndView model) {
        Pet petObj = new Pet();
        model.addObject("petObj", petObj);
        model.setViewName("save");
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Pet petObj) {
        petService.doSave(petObj);
        return new ModelAndView("redirect:/view");
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Pet petObj = petService.doGetById(id);
        ModelAndView model = new ModelAndView("edit");
        model.addObject("petObj", petObj);
        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateContact(@ModelAttribute Pet petObj) {
        petService.doUpdate(petObj);
        return new ModelAndView("redirect:/view");
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        petService.doDelete(id);
        return new ModelAndView("redirect:/view");
    }
    
    @RequestMapping(value = "/error")
    public String error() {
        return "access-denied";
    }
}
