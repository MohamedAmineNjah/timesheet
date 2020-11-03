package tn.esprit.spring;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetApplicationTests {
	@Autowired
	IEmployeService iemployeservice;

	@Autowired
	EmployeRepository employerepository;
	@Autowired
	MissionRepository missionrepository;

	@Autowired
	ContratRepository contratrepository;

	@Autowired
	EntrepriseRepository entrepriserepository;

	@Autowired
	DepartementRepository deptRepoistory;

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/*****************************
	 * ok partie dorra
	 ***************************************/
	/*
	 * @Test public void contextLoads() { }
	 */

	// @Test
	// public void testdeleteContratById() {
	//
	// Contrat c = new Contrat(1, "typ1", 2);
	// iemployeservice.ajouterContrat(c);
	// iemployeservice.deleteContratById(c.getReference());
	// assertNull(employerepository.findById(c.getReference()));
	// }
	//
	// @Test
	// public void getNombreEmployeJPQL() {
	//
	// Employe e1 = new Employe("salah", "salah", "s.s@gmail.tn", true,
	// Role.INGENIEUR);
	// Employe e2 = new Employe("mohamed", "mohamed", "m.m@gmail.tn", true,
	// Role.ADMINISTRATEUR);
	// iemployeservice.addOrUpdateEmploye(e1);
	// iemployeservice.addOrUpdateEmploye(e2);
	// int nbr = iemployeservice.getNombreEmployeJPQL();
	// assertEquals(2, nbr);
	// }
	//
	// @Test
	// public void getAllEmployeNamesJPQL() {
	//
	// List<String> L = iemployeservice.getAllEmployeNamesJPQL();
	// String name = L.get(0);
	// assertEquals("s", name);
	// }

	/*
	 * @Test public void getAllEmployes() {
	 * 
	 * List<Employe> L = iemployeservice.getAllEmployes();
	 * 
	 * assertEquals(1, L.size()); }
	 * 
	 */
	/*
	 * 
	 * @Test public void getAllEmployeByEntreprise() {
	 * 
	 * Entreprise E = entrepriserepository.findById(1).get(); List<Employe> L =
	 * iemployeservice.getAllEmployeByEntreprise(E); String name =
	 * L.get(0).getNom(); assertEquals("a", name); }
	 */
	/*
	 * @Test public void mettreAjourEmailByEmployeIdJPQL() {
	 * 
	 * 
	 * int id = employerepository.findById(1).get().getId();
	 * iemployeservice.mettreAjourEmailByEmployeIdJPQL("new.new@gmail.tn", id);
	 * assertEquals("new.new@gmail.tn",
	 * employerepository.findById(1).get().getEmail()); }
	 */

	/*
	 * @Test public void deleteAllContratJPQL() {
	 * 
	 * iemployeservice.deleteAllContratJPQL() ;
	 * assertNull(contratrepository.findAll() ); }
	 * 
	 */

	// @Test public void getSalaireByEmployeIdJPQL() {
	//
	//
	// assertEquals(200,
	// iemployeservice.getSalaireByEmployeIdJPQL(employerepository.findById(1).get()
	// .getId()));
	//
	// }

	// @Test public void getTimesheetsByMissionAndDate() {
	// *
	// * Employe e = employerepository.findById(1).get(); Mission m =
	// * missionrepository.findById(1).get(); Date dateDebut =
	// * parseDate("2010-01-01"); Date dateFin = parseDate("2025-01-01");
	// *
	// *
	// * List<Timesheet> t = iemployeservice.getTimesheetsByMissionAndDate(e, m,
	// * dateDebut, dateFin) ; assertNotNull(t);
	// *
	// * }
	// */
	/*****************************
	 * fin partie dorra
	 ***************************************/

	/*****************************
	 * début partie Njah
	 ***************************************/
	/*
	 * @Test public void testauthenticate() {
	 * 
	 * Employe e1 = new Employe("salah", "salah", "s.s@gmail.tn","pass", true,
	 * Role.INGENIEUR); iemployeservice.addOrUpdateEmploye(e1); Employe e =
	 * iemployeservice.authenticate("salah", "pass"); System.out.println(
	 * "************************************************************************");
	 * if (e == null) System.out.println("nuuuuuuuuuuuuuuuuullll");
	 * assertEquals("salah", e.getNom()); }
	 */
	/*
	 * @Test public void testaddOrUpdateEmploye() { int nbr =
	 * iemployeservice.getNombreEmployeJPQL() ; Employe e2 = new Employe("mohamed",
	 * "mohamed", "m.m@gmail.tn", true, Role.ADMINISTRATEUR);
	 * iemployeservice.addOrUpdateEmploye(e2);
	 * 
	 * assertEquals(nbr+1, iemployeservice.getNombreEmployeJPQL()); }
	 */
	/*
	 * @Test public void testmettreAjourEmailByEmployeId() { int id =
	 * employerepository.findById(16).get().getId();
	 * iemployeservice.mettreAjourEmailByEmployeId("new.new@gmail.tn", id);
	 * assertEquals("new.new@gmail.tn",
	 * employerepository.findById(16).get().getEmail()); }
	 */
	/*
	 * @Test public void testaffecterEmployeDuDepartement() {
	 * iemployeservice.affecterEmployeADepartement(15,1); Departement dep =
	 * deptRepoistory.findById(1).get(); Employe employe =
	 * employerepository.findById(15).get();
	 * 
	 * int id1 = employe.getDepartements().get(0).getId();
	 * 
	 * assertEquals(1,id1); }
	 */
	/*
	 * @Test public void testdesaffecterEmployeDuDepartement() {
	 * iemployeservice.desaffecterEmployeDuDepartement(15,1); Departement dep =
	 * deptRepoistory.findById(1).get(); Employe employe =
	 * employerepository.findById(15).get();
	 * 
	 * assertEquals("", employe.getDepartements());
	 * 
	 * }
	 */
	/*
	 * @Test public void testdeleteEmployeById() { int nbr =
	 * iemployeservice.getNombreEmployeJPQL() ;
	 * iemployeservice.deleteEmployeById(19);
	 * 
	 * assertEquals(nbr-1, iemployeservice.getNombreEmployeJPQL()); }
	 */
	/*
	 * @Test public void testajouterContrat() { int nbr =
	 * contratrepository.countcont() ; Contrat c = new Contrat(1, "typ1", 2);
	 * iemployeservice.ajouterContrat(c);
	 * 
	 * assertEquals(nbr+1, contratrepository.countcont()); }
	 */

	/*****************************
	 * fin partie Njahh
	 ***************************************/

	/*****************************
	 * Debut partie saadouli
	 ***************************************/

	Employe employe = new Employe(1, "oussema", "saadouli");
	Departement departement = new Departement(1, "Atlas");

	@Before
	public void init() {
		deptRepoistory.save(departement);
		employerepository.save(employe);
	}

	@Test
	public void testingAffecterEmployeADepartement() {
		 iemployeservice.affecterEmployeADepartement(1,1);
		 assertEquals(false,iemployeservice.getAllEmployeByDepartement(departement).isEmpty());
	}

	 @Test
	 public void testingDesaffecterEmployeDuDepartement() {
	 iemployeservice.desaffecterEmployeDuDepartement(1,1);
	 assertEquals(true,iemployeservice.getAllEmployeByDepartement(departement).isEmpty());
	 }

	// @After
	// public void destroy() {
	// iemployeservice.desaffecterEmployeDuDepartement(8,1);
	// assertEquals(true,iemployeservice.getAllEmployeByDepartement(departement).isEmpty());
	// }

	 @Test
	 public void testingAddContrat() {
	 int nbr = (int) contratrepository.count();
	 Contrat c = new Contrat(23181323, "CDO", 1000.0f);
	 iemployeservice.ajouterContrat(c);
	
	 assertEquals(nbr + 1, contratrepository.count());
	 }
	
	 @Test
	 public void testingDeleteAllContratJPQL() {
	 iemployeservice.deleteAllContratJPQL();
	 assertEquals(true,iemployeservice.deleteAllContratJPQL());
	 }
	
	
	
	 @Test
	 public void testingDeleteContratById() {
	 Contrat c = new Contrat(1, "typ1", 2);
	 iemployeservice.ajouterContrat(c);
	 iemployeservice.deleteContratById(c.getReference());
	// assertNull(employerepository.findById(c.getReference()));
	 assertEquals(Optional.empty(), employerepository.findById(c.getReference()));
	 }
	

	 @Test
	 public void testingGetAllEmployes() {
	 iemployeservice.getAllEmployes();
	 assertEquals(true,iemployeservice.deleteAllContratJPQL());
	 }

	 /*****************************fin partie Saadouli***************************************/

}
