package com.dalel.vetements.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dalel.vetements.dto.VetementDTO;
import com.dalel.vetements.entities.Vetement;
import com.dalel.vetements.service.VetementService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class VetementRESTController {
	@Autowired
	VetementService vetementService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<VetementDTO> getAllVetement(){
		return vetementService.getAllVetement();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public VetementDTO getVetementById(@PathVariable("id") Long id) {
	return vetementService.getVetement(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public VetementDTO createVetement(@RequestBody VetementDTO vetementDTO) {
		return vetementService.saveVetement(vetementDTO);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public VetementDTO updateVetement(@RequestBody VetementDTO vetementDTO) {
	return vetementService.updateVetement(vetementDTO);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteVetement(@PathVariable("id") Long id)
	{
		vetementService.deleteVetementById(id);
	}
	@RequestMapping(value="/vetIdG/{IdG}",method = RequestMethod.GET)
	public List<Vetement> getVetementByGenresId(@PathVariable("IdG") Long IdG) {
	return vetementService.findByGenresIdG(IdG);
	}
	
	
	
	
	
}
