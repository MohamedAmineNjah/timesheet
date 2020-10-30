package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

/*Ghassen*/
/*Ghassen*/
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
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
		
		/*Optional<Departement> value = deptRepoistory.findById(depId);
		Optional<Employe> valuee = employeRepository.findById(employeId);

		if (value.isPresent()) {
			Departement depManagedEntity = value.get();
		

			if (valuee.isPresent()) {
				Employe employeManagedEntity = valuee.get();
				*/
				l.info("Finding entreprise by Id, wait plz...");
				Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
				l.info("Finding department by Id, wait plz...");
				Departement depManagedEntity = deptRepoistory.findById(depId).get();
				l.info("Affecting department to entreprise...");
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				deptRepoistory.save(depManagedEntity);
		
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		l.info("Finding Entreprise by Id...");
		Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).get();
		List<String> depNames = new ArrayList<>();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			l.info("Getting the Entreprise departments...");
			depNames.add(dep.getName());
		}
		
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		l.info("Deleting Entreprise...");
		entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).get());	
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		l.info("Deleting Department...");
		deptRepoistory.delete(deptRepoistory.findById(depId).get());	
	}


	public Entreprise getEntrepriseById(int entrepriseId) {
		l.info("Getting Entreprise by Id...");
		return entrepriseRepoistory.findById(entrepriseId).get();	
	}

}
