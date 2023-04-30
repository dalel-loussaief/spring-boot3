package com.dalel.vetements;
import com.dalel.vetements.entities.Genres;
import java.util.Date;
import java.util.List;

import com.dalel.vetements.entities.Vetement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.dalel.vetements.repos.VetementRepository;
import com.dalel.vetements.service.VetementService;
@SpringBootTest
class VetementsApplicationTests {
	@Autowired
	private VetementRepository VetementRepository;
	@Autowired
	private VetementService vetementService;

	@Test
	public void testCreateVetement() {
		Vetement v = new Vetement("robe","s",80.900,new Date());
		 VetementRepository.save(v);
	}
	/*@Test
	public void testFindVetement()
	{
		Vetement v = VetementRepository.findById(1L).get(); 
		System.out.println(v);
	}
	@Test
	public void testUpdateVetement()
	{
		Vetement v = VetementRepository.findById(1L).get(); 
		v.setPrixvetement(100.0);
		VetementRepository.save(v);
	}
	@Test
	public void testDeleteVetement()
	{
		VetementRepository.deleteById(1L);;
	}*/
	@Test
	public void testListerTousVetement()
	{
	List<Vetement> vet = VetementRepository.findAll();
	for (Vetement v : vet)
	{
	System.out.println(v);
	}
	}
	@Test
	public void testFindByNomVetementContains()
	{
	Page<Vetement> prods = vetementService.getAllVetementParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}
	@Test
	public void testFindBynomvetement()
	{
		List<Vetement> vet = VetementRepository.findBynomvetement("robe");
		for (Vetement v :vet )
		{
		System.out.println(v);
		} 
	}
	
	@Test
	public void testFindBynomvetementContains()
	{
		List<Vetement> vet = VetementRepository.findBynomvetementContains("r");
		for (Vetement v :vet )
		{
		System.out.println(v);
		} 
	}
	
	@Test
	public void testfindByNomPrix()
	{
	List<Vetement> prods = VetementRepository.findByNomPrix("robe", 200.0);
	for (Vetement p : prods)
	{
	System.out.println(p);
	}
	}

	@Test
	public void testfindByGenres()
	{
		Genres c = new Genres();
	c.setIdG(1L);
	List<Vetement> vet = VetementRepository.findByGenres(c);
	for (Vetement v : vet)
	{
	System.out.println(v);
	}
	}
	
	
	@Test
	public void findByGenresIdG()
	{
	List<Vetement> vet =  VetementRepository.findByGenresIdG(1L);
	for (Vetement v : vet)
	{
	System.out.println(v);
	}
	 }
	
	@Test
	public void testfindByOrderByNomvetementAsc()
	{
	List<Vetement> vet = 
			VetementRepository.findByOrderByNomvetementAsc();
	for (Vetement v : vet)
	{
	System.out.println(v);
	}
	}

	@Test
	public void  trierVetementNomsPrix()
	{
	List<Vetement> prods =VetementRepository.trierVetementNomsPrix();
	for (Vetement p : prods)
	{
	System.out.println(p);
	}
	}
	
	
	
	
}
