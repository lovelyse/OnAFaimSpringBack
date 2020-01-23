package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Commande;
import model.Etat;


public interface CommandeRepository extends JpaRepository<Commande, Long> {
	
	List<Commande> findAllByEtat(Etat etat);
	
}

