package dao;

import java.util.List;

import model.Commande;
import model.Etat;


public interface DAOCommande extends DAOGeneric<Commande,Long> {
	
	public List<Commande> findCommandeByCEtat(Etat cEtat);
	
}

