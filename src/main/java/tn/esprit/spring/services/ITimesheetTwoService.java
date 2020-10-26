package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;

public interface ITimesheetTwoService {
	
	public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId);
	public List<Mission> findAllMissionByEmployeJPQL(int employeId);
	public List<Employe> getAllEmployeByMission(int missionId);
}
