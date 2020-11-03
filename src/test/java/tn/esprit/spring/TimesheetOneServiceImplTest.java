package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;
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
	
	
	
	
	
}
