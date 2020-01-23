package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Produit;
import model.TailleProduit;
import model.TypeProduit;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
	
	List<Produit> findAllByTailleProduit(TailleProduit taille); 
	List<Produit> findAllByTypeProduit(TypeProduit type); 
	
}
