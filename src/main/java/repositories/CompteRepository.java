package dao;

import java.util.List;

import model.Compte;
import model.Etat;
import model.TypeCompte;


public interface DAOCompte extends DAOGeneric<Compte,Long> {

	public Compte checkConnect(String email,String mdp) ;
	public List<Compte> findByType(TypeCompte type);
	public List<Compte> findByAccountStatus(Etat etat);
}

