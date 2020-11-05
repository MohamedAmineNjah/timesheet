package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetOneService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetOneServiceImplTest {

	@Autowired
	ITimesheetOneService timesheetService;
	@Autowired
	MissionRepository missionRepo;
	@Autowired
	IEntrepriseService entrepriseService;
	@Autowired
	IEmployeService employeService;
	
	
	@Test public void contextLoads() { }
	
	
	@Test
	public void testAjoutMission() {
		Mission m = new Mission("mission1","mission de développement à France");
		int missionId = timesheetService.ajouterMission(m);
		assertNotNull(missionId);
	}
	
	
	@Test
	public void testAffecterMissionADepartement() {
		Departement dep = new Departement("Informatique");
		int depId = entrepriseService.ajouterDepartement(dep);
		timesheetService.affecterMissionADepartement(1, depId);
		assertEquals(missionRepo.findById(1).get().getDepartement().getId(),depId);
	}
	
	
	@Test
	public void testAjoutTimesheet() throws ParseException {
		Employe emp = new Employe("alaeddine","hnana","alaeddine.hnana@esprit.tn",true,Role.ADMINISTRATEUR);
		int empId = employeService.addOrUpdateEmploye(emp);
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		Date dateDebut = format.parse("2020-12-01");
		Date dateFin = format.parse("2021-12-05");
		Timesheet timesheet = timesheetService.ajouterTimesheet(1, empId, dateDebut, dateFin);
		assertNotNull(timesheet);
				
	}
	
}
