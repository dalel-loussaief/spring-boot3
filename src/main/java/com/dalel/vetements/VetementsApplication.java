package com.dalel.vetements;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import com.dalel.vetements.entities.Vetement;
import com.dalel.vetements.service.VetementService;

@SpringBootApplication
public class VetementsApplication implements CommandLineRunner{

	@Autowired
	VetementService vetementService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(VetementsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//vetementService.saveVetement(new Vetement("jupe","M",40.300,new Date()));
		//vetementService.saveVetement(new Vetement("pantallon","L",100.900,new Date()));
		//vetementService.saveVetement(new Vetement("jupe","M",150.900,new Date()));
		repositoryRestConfiguration.exposeIdsFor(Vetement.class);
	}
	
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}
}
