package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entities.Contrat;


public interface IContratService {
	
	public int addContrat(Contrat contrat);
	public List<Contrat> getAllContrats();
	public void affecterContratAEmploye(int contratId, int empId);

}
