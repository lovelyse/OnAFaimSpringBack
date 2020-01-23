package repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Commande;
import model.Devis;
import model.Etat;

public interface DevisRepository extends JpaRepository<Devis,Long> {

	//List<Devis> findAllDevisByDetat(Etat cEtat);

	
	 
}
