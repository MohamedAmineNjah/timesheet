package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class ContratServiceImpl implements IContratService {

	
	private static final Logger l = Logger.getLogger(EmployeServiceImpl.class);
	

	@Autowired
	ContratRepository contratRepository;
	@Autowired
	EmployeRepository employeRepository;


	
	public int addContrat(Contrat contrat) {
		l.info("Début de l'exécution de la méthode d'ajout d'un contrat");
		l.debug("Ajout d'un contrat");
		contratRepository.save(contrat);
		l.debug("Fin de l'ajout d'un contrat");
		l.info("Fin de l'exécution de la méthode d'ajout d'un contrat");
		l.debug("Return de l'identifiant du contrat ajouté");
		return contrat.getReference();
	}
	
	
	public List<Contrat> getAllContrats() {
		l.info("Début de l'exécution de la méthode getAllContrats ");
		l.info("Fin de l'exécution de la méthode getAllContrats");
		l.debug("Return de la liste");
		return (List<Contrat>) contratRepository.findAll();
	}
	
	public void affecterContratAEmploye(int contratId, int empId) {
		l.info("Début de l'exécution de la méthode d'affectation d'un contrat à un employé");
		l.debug("Récupération du contrat dont l'id est donné en paramètres");
		Optional<Contrat> contrat = contratRepository.findById(contratId);
		l.debug("Test si le contrat récupéré existe ou pas");
		if(contrat.isPresent()) {
			l.info("Contrat récupérée");
			l.debug("Récupération de l'employé dont l'id est donné en paramètres");
			Optional<Employe> emp = employeRepository.findById(empId);
			l.debug("Test si l'employé récupéré existe ou pas");
		if(emp.isPresent()) {
			l.info("Employé récupéré");	
			l.debug("Affecter le contrat récupéré à l'employé récupéré");
			contrat.get().setEmploye(emp.get());
			l.debug("Enregistrer l'affectation dans l'entité contrat");
			contratRepository.save(contrat.get());
			l.info("Fin de l'exécution de la méthode d'affectation d'un contrat à un employé");
			}
			else {
				l.error("L'employé dont l'id donné est introuvable");
			}
		}
		else {
			l.error("Le contrat dont l'id donné est introuvable");
		}
		}

}
