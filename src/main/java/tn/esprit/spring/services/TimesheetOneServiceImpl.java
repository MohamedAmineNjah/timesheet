package tn.esprit.spring.services;

import java.util.Date;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class TimesheetOneServiceImpl implements ITimesheetOneService {
	

	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;
	
	
	private static final Logger l = Logger.getLogger(TimesheetOneServiceImpl.class);
	
	public int ajouterMission(Mission mission) {
		l.info("Début de l'exécution de la méthode d'ajout d'une mission");
		l.debug("Ajout d'une mission");
		missionRepository.save(mission);
		l.debug("Fin de l'ajout d'une mission");
		l.info("Fin de l'exécution de la méthode d'ajout d'une mission");
		l.debug("Return de l'identifiant de la mission ajoutée");
		return mission.getId();
		
	}
    
	public void affecterMissionADepartement(int missionId, int depId) {
		l.info("Début de l'exécution de la méthode d'affectation d'une mission à un département");
		l.debug("Récupération de la mission dont l'id est donné en paramètres");
		Optional<Mission> mission = missionRepository.findById(missionId);
		l.debug("Test si la mission récupérée existe ou pas");
		if(mission.isPresent()) {
			l.info("Mission récupérée");
			l.debug("Récupération du département dont l'id est donné en paramètres");
			Optional<Departement> dep = deptRepoistory.findById(depId);
			l.debug("Test si le département récupéré exist ou pas");
		if(dep.isPresent()) {
			l.info("Département récupéré");	
			l.debug("Affecter le département récupéré à la mission récupérée");
			mission.get().setDepartement(dep.get());
			l.debug("Enregistrer l'affectation dans l'entité mission");
			missionRepository.save(mission.get());
			l.info("Fin de l'exécution de la méthode d'affectation d'une mission à un département");
			}
			else {
				l.error("Le département dont l'id donné est introuvable");
			}
		}
		else {
			l.error("La mission dont l'id donné est introuvable");
		}
		
		}

	public Timesheet ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		l.info("Début de l'exécution de la méthode d'ajout d'un timesheet");
		l.debug("Création d'une instance Timesheet Primary Key");
		TimesheetPK timesheetPK = new TimesheetPK();
		l.debug("Ajout du date de debut paramétrée dans l'instance Timesheet Primary Key");
		timesheetPK.setDateDebut(dateDebut);
		l.debug("Ajout du date de fin paramétrée dans l'instance Timesheet Primary Key");
		timesheetPK.setDateFin(dateFin);
		l.debug("Ajout du date de l'id employé paramétrée dans l'instance Timesheet Primary Key");
		timesheetPK.setIdEmploye(employeId);
		l.debug("Ajout du date de l'id mission paramétrée dans l'instance Timesheet Primary Key");
		timesheetPK.setIdMission(missionId);
		l.debug("Instanciation d'une entité Timesheet");
		Timesheet timesheet = new Timesheet();
		l.debug("Ajouter la clé primaire dans l'entité Timesheet");
		timesheet.setTimesheetPK(timesheetPK);
		l.debug("Modifier l'attribut Valide de l'entité Timesheet");
		timesheet.setValide(false);
		l.debug("Enregistrer l'ajout de l'entité Timesheet");
		timesheetRepository.save(timesheet);
		l.info("Fin de l'exécution de la méthode d'ajout d'un timesheet");
		l.debug("Retourner l'entité Timesheet");
		return timesheet;
		
	}

}
