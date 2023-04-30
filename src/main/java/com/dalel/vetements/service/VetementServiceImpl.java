package com.dalel.vetements.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dalel.vetements.dto.VetementDTO;
import com.dalel.vetements.entities.Genres;
import com.dalel.vetements.entities.Vetement;
import com.dalel.vetements.repos.VetementRepository;
@Service
public class VetementServiceImpl implements VetementService {

	@Autowired
	VetementRepository vetementRepository;
	@Autowired(required = false)
	ModelMapper modelMapper;

	
	@Override
	public VetementDTO saveVetement(VetementDTO v) {
		
		return convertEntityToDto(vetementRepository.save(convertDtoToEntity(v)));
	}

	@Override
	public VetementDTO updateVetement(VetementDTO v) {
		
		return convertEntityToDto(vetementRepository.save(convertDtoToEntity(v)));
	}

	@Override
	public void deleteVetement(Vetement v) {
		 vetementRepository.delete(v);
		
	}

	@Override
	public void deleteVetementById(Long id) {
		vetementRepository.deleteById(id);
		
	}

	@Override
	public VetementDTO getVetement(Long id) {
		
		return convertEntityToDto (vetementRepository.findById(id).get());
	}

	@Override
	public List<VetementDTO> getAllVetement() {
		
	return vetementRepository.findAll().stream()
			 .map(this::convertEntityToDto)
			 .collect(Collectors.toList());
		//OU BIEN
		/*List<Vetement> prods = vetementRepository.findAll();
		List<VetementDTO> listvetDto = new ArrayList<>(prods.size());
		for (Vetement p : prods)
		listvetDto.add(convertEntityToDto(p));
		return listvetDto;*/

	}

	@Override
	public Page<Vetement> getAllVetementParPage(int page, int size) {
		
		return  vetementRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Vetement> findBynomvetement(String nomvetement) {
		
		return vetementRepository.findBynomvetement(nomvetement);
	}

	@Override
	public List<Vetement> findBynomvetementContains(String nomvetement) {
		
		return vetementRepository.findBynomvetementContains(nomvetement);

	}

	@Override
	public List<Vetement> findByNomPrix(String nom, Double prix) {
		
		return vetementRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Vetement> findByGenres(Genres genres) {
		
		return vetementRepository.findByGenres(genres);
	}

	@Override
	public List<Vetement> findByGenresIdG(Long id) {
		
		return vetementRepository.findByGenresIdG(id);
	}

	@Override
	public List<Vetement> findByOrderByNomvetementAsc() {
		
		return vetementRepository.findByOrderByNomvetementAsc();
	}

	@Override
	public List<Vetement> trierVetementNomsPrix() {
		
		return vetementRepository.trierVetementNomsPrix();
	}

	@Override
	public VetementDTO convertEntityToDto(Vetement vetement) {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		VetementDTO vetementDTO= modelMapper.map(vetement, VetementDTO.class);
		 return vetementDTO; 
		
		
		
		
		/*VetementDTO vetementDTO=new VetementDTO();
		vetementDTO.setIdvetement(v.getIdvetement());
		vetementDTO.setNomvetement(v.getNomvetement());
		vetementDTO.setPrixvetement(v.getPrixvetement());
		vetementDTO.setDateprod(v.getDateprod());
		vetementDTO.setGenres(v.getGenres());
		
		return vetementDTO;*/
		
		/*return VetementDTO.builder()
		.Idvetement(v.getIdvetement())
		.Nomvetement(v.getNomvetement())
		.Prixvetement(v.getPrixvetement())
		.Dateprod(v.getDateprod())
		.Genres(v.getGenres())
		.build();
		*/
		
	}
	
	@Override
	public Vetement convertDtoToEntity(VetementDTO vetementDto) {
	Vetement vetement = new Vetement();
	vetement = modelMapper.map(vetementDto, Vetement.class);
	 vetement.setIdvetement(vetementDto.getIdvetement());
	 vetement.setNomvetement(vetementDto.getNomvetement());
	 vetement.setPrixvetement(vetementDto.getPrixvetement());
	 vetement.setDateprod(vetementDto.getDateprod());
	 vetement.setGenres(vetementDto.getGenres()); 
	 return vetement; 
	}
	
	

	
}
