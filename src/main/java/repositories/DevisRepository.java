package dao;

import java.util.List;

import model.Commande;
import model.Devis;
import model.Etat;

public interface DAODevis extends DAOGeneric<Devis,Long> {

	public List<Devis> findDevisByCEtat(Etat cEtat);
	
}
