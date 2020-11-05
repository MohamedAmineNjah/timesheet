package tn.esprit.spring.services;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
@Service
public class TimesheetTwoServiceImpl implements ITimesheetTwoService {
	
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;
	

	private static final Logger l = Logger.getLogger(TimesheetTwoServiceImpl.class);
	
	public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {
		
		l.info("In valider Timesheet");
		
		Optional<Employe> validateur = employeRepository.findById(validateurId);
		Optional<Mission> mission = missionRepository.findById(missionId);
		
		//verifier s'il est un chef de departement (interet des enum)
		if(validateur.isPresent() && !validateur.get().getRole().equals(Role.CHEF_DEPARTEMENT)){
			l.error("l'employe doit etre chef de departement pour valider une feuille de temps !");
			return;
		}
		
		
		
		if(validateur.isPresent()) {
		//verifier s'il est le chef de departement de la mission en question
		boolean chefDeLaMission = false;
		for(Departement dep : validateur.get().getDepartements()){
			if(mission.isPresent() && dep.getId() == mission.get().getDepartement().getId()){
				chefDeLaMission = true;
				break;
			}
		}
		if(!chefDeLaMission){
			l.error("l'employe doit etre chef de departement de la mission en question");
			return;
		}

		l.debug("Création Timesheet");		
		Timesheet timesheet =timesheetRepository.findByMission(mission.get());
		l.info("Validation Timesheet");
		timesheet.setValide(true);
		timesheetRepository.save(timesheet);
		
		//Comment Lire une date de la base de données
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		l.info("dateDebut : " + dateFormat.format(timesheet.getTimesheetPK().getDateDebut()));
		l.info("Out of valider Timesheet");
	}
	}
	
	public List<Mission> findAllMissionByEmployeJPQL(int employeId) {
		l.info("In findAllMissionByEmployeJPQL");
		return timesheetRepository.findAllMissionByEmployeJPQL(employeId);
	}

	
	public List<Employe> getAllEmployeByMission(int missionId) {
		l.info("In getAllEmployeByMission");
		return timesheetRepository.getAllEmployeByMission(missionId);
	}

}
