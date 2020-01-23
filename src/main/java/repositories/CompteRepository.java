package repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Compte;
import model.Etat;
import model.TypeCompte;


public interface CompteRepository extends JpaRepository<Compte, Long> {

	//@Query("from Compte c where email=:email and mdp=:mdp")
	Optional<Compte> findByEmailAndMdp(String email,String mdp);
	
	//@Query("from Compte c where type=:type")	
	List<Compte> findAllByType(TypeCompte type);
	
	//@Query("from Compte c where compteEtat=:etat")
	List<Compte> findAllByCompteEtat(Etat etat);
	
}

