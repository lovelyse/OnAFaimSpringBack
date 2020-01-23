package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import model.LigneCommande;
import model.LigneCommandePK;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande,LigneCommandePK> {

}
