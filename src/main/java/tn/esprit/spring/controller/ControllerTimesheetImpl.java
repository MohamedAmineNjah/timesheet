package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetOneService;
import tn.esprit.spring.services.ITimesheetTwoService;

@Controller
public class ControllerTimesheetImpl {

	@Autowired
	IEmployeService iemployeservice;
	@Autowired
	IEntrepriseService ientrepriseservice;
	@Autowired
	ITimesheetOneService itimesheetoneservice;
	@Autowired
	ITimesheetTwoService itimesheettwoservice;

	public int ajouterMission(Mission mission) {
		itimesheetoneservice.ajouterMission(mission);
		return mission.getId();
	}

	public void affecterMissionADepartement(int missionId, int depId) {
		itimesheetoneservice.affecterMissionADepartement(missionId, depId);

	}
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		itimesheetoneservice.ajouterTimesheet(missionId, employeId, dateDebut, dateFin);

	}

	
	public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {
		itimesheettwoservice.validerTimesheet(missionId, employeId, dateDebut, dateFin, validateurId);

	}
	public List<Mission> findAllMissionByEmployeJPQL(int employeId) {

		return itimesheettwoservice.findAllMissionByEmployeJPQL(employeId);
	}


	public List<Employe> getAllEmployeByMission(int missionId) {

		return itimesheettwoservice.getAllEmployeByMission(missionId);
	}
}
