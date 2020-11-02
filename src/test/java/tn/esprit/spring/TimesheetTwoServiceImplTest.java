package tn.esprit.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

public class TimesheetTwoServiceImplTest {

	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;
	
	@Test
	public void testValiderTimesheet() {
		
	}
	
	@Test
	public void testFindAllMissionByEmployeJPQL() {
		
	}
	
	@Test
	public void testGetAllEmployeByMission() {
		
	}
}
