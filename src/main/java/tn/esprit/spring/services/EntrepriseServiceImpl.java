package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

/*Ghassen*/
/*Ghassen Belhouchet*/
/*BelhouchetGhassenppp*/
@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	private static final Logger l = Logger.getLogger(EntrepriseServiceImpl.class);

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	public int ajouterEntreprise(Entreprise entreprise) {
		l.info("Adding Entreprise please wait...");
		entrepriseRepoistory.save(entreprise);
		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		l.info("Adding Department please wait...");
		deptRepoistory.save(dep);
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		l.info("Affecting Department to entreprise, wait plz...");
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
		
		Optional<Departement> value = deptRepoistory.findById(depId);
		Optional<Entreprise> valuee = entrepriseRepoistory.findById(entrepriseId);

		if (value.isPresent()) {
			Departement depManagedEntity = value.get();
		

			if (valuee.isPresent()) {
				Entreprise entrepriseManagedEntity = valuee.get();
				
				if(depManagedEntity.getEntreprise() == null){

					Entreprise entreprise = new Entreprise();
					entreprise.addDepartement(depManagedEntity);
				depManagedEntity.setEntreprise(entreprise);
			}else{
				
				
				
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				deptRepoistory.save(depManagedEntity);
			}}}
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		l.info("Getting Entreprise's departments...");
		Optional<Entreprise> value = entrepriseRepoistory.findById(entrepriseId);
		
		
			if (value.isPresent()) {
				Entreprise entrepriseManagedEntity = value.get();
			
					
		List<String> depNames = new ArrayList<>();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			Optional<Departement> value1 = deptRepoistory.findById(dep.getId());
			if (value1.isPresent()) {
			Departement depManagedEntity = value1.get();
			depNames.add(depManagedEntity.getName());
			return depNames;
		}
		
	}
	}
	return Collections.emptyList();
	
	
}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		l.info("Deleting Entreprise...");
		Optional<Entreprise> value = entrepriseRepoistory.findById(entrepriseId);		
		if (value.isPresent()) {
			Entreprise entrepriseManagedEntity = value.get();
		entrepriseRepoistory.delete(entrepriseManagedEntity);	
	}
	
}

	@Transactional
	public void deleteDepartementById(int depId) {
		l.info("Deleting Department...");
		Optional<Departement> value = deptRepoistory.findById(depId);		
		if (value.isPresent()) {
			Departement depManagedEntity = value.get();
		deptRepoistory.delete(depManagedEntity);	
	}
}


	public Entreprise getEntrepriseById(int entrepriseId) {
		l.info("Getting Entreprise by Id...");
		Optional<Entreprise> value = entrepriseRepoistory.findById(entrepriseId);		
		if (value.isPresent()) {
			
		Entreprise entrepriseManagedEntity = value.get();	
		return entrepriseManagedEntity;
	}
	return null;

	}
}
