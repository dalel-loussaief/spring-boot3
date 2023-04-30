package com.dalel.vetements.controllers;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dalel.vetements.dto.VetementDTO;
import com.dalel.vetements.entities.Genres;
import com.dalel.vetements.entities.Vetement;
import com.dalel.vetements.service.VetementService;

@Controller
public class VetementsControllers {

	@Autowired
	VetementService vetementService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		modelMap.addAttribute("Vetement", new Vetement());
		modelMap.addAttribute("mode", "new");
		return "formVetement";
	}
	@RequestMapping("/saveVetement")
	public String saveVetement(@Valid VetementDTO vetement,
				BindingResult bindingResult){
			if (bindingResult.hasErrors())return "formVetement";
			System.out.println(vetement);
			vetementService.saveVetement(vetement);
				return "formVetement";
			
	}
	/*@PostMapping("/saveVetement")
	public String saveLivre(@ModelAttribute("vetement") @Valid Vetement vetement,
	                         @RequestParam("Genres") Long IdG,
	                         @RequestParam("sexe") String sexe,
	                         Model model, BindingResult bindingResult) throws ParseException {
		// Vetement vetement = vetementService.getVetement(idvetement);
		// Genres getGenres (  genres );

	   
	    if (bindingResult.hasErrors()) {
	        model.addAttribute("vetement", vetementService.getAllVetement());
	        return "formVetement";
	    }

	    vetementService.saveVetement(vetement);

	    return "redirect:/formVetement";
	}*/

	@RequestMapping("/ListeVetements")
	public String listeVetement(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)

	{
	Page<Vetement> vet= vetementService.getAllVetementParPage(page,size);
	modelMap.addAttribute("vetements", vet);
	modelMap.addAttribute("pages", new int[vet.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "ListeVetements";
	}
	@RequestMapping("/supprimervetement")
	public String supprimerVetement(@RequestParam("id") Long id,
	 ModelMap modelMap,
	 @RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)

	{ 
	vetementService.deleteVetementById(id);
	Page<Vetement> p = vetementService.getAllVetementParPage(page,size);
	modelMap.addAttribute("vetements", p);
	modelMap.addAttribute("pages", new int[p.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "ListeVetements";
	}
	@RequestMapping("/modifiervetement")
	public String editerVetement(@RequestParam("id")Long id,ModelMap modelMap)
			
	{
	VetementDTO v= vetementService.getVetement(id);
	modelMap.addAttribute("Vetement", v);
	modelMap.addAttribute("mode", "edit");
	return "formVetement";
	}
	@RequestMapping("/updateVetement")
	public String updateVetement(@ModelAttribute("vetement")VetementDTO vetement,
	@RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 vetement.setDateprod(dateCreation);
	 
	 vetementService.updateVetement(vetement);
	 List<VetementDTO> prods = vetementService.getAllVetement();
	 modelMap.addAttribute("vetements", prods);
	return "ListeVetements";
	}

	
	
}
