package tn.esprit.spring;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import tn.esprit.spring.services.TimesheetTwoServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetTwoServiceImplTest {

	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	TimesheetTwoServiceImpl timesheetTwoServiceImpl;
	
	@Test public void contextLoads() { }
	@Test
	public void testFindByMission() {
		Timesheet timesheet = timesheetRepository.findByMission(missionRepository.findById(1002).get());
		assertEquals(1002, timesheet.getMission().getId());
		
	}
	
	@Test
	public void testValiderTimesheet() {
		Timesheet timesheet =timesheetRepository.findByMission(missionRepository.findById(1002).get());
		assertTrue(timesheet.isValide());
	}
	
	@Test
	public void testFindAllMissionByEmployeJPQL() {
		assertNotNull(timesheetTwoServiceImpl.findAllMissionByEmployeJPQL(3));
	}
	
	@Test
	public void testGetAllEmployeByMission() {
		assertNotNull(timesheetTwoServiceImpl.getAllEmployeByMission(1002));	
	}
	
}
