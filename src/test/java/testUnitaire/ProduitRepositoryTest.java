package testUnitaire;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Produit;
import model.TailleProduit;
import model.TypeProduit;
import repositories.ProduitRepository;




@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations= {"/application-context.xml"})
public class ProduitRepositoryTest {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Test
	public void testInsertAndDelete(){
		Produit p = new Produit("chocolatine", TailleProduit.maxi, 3, TypeProduit.Viennoiserie, "une joli chocolatine du sud ouest");
		produitRepository.save(p);
		assertNotNull(produitRepository.findById(p.getId()));
		produitRepository.delete(p);
        Optional<Produit> opt= produitRepository.findById(p.getId());
        assertFalse(opt.isPresent());
	}
	
	@Test
	public void testFindAllByTaille() {
		Produit p = new Produit("chocolat1", TailleProduit.maxi, 3, TypeProduit.Viennoiserie, "une joli chocolatine du sud ouest");
		produitRepository.save(p);
		Produit p2 = new Produit("chocolat2", TailleProduit.maxi, 3, TypeProduit.Viennoiserie, "une joli chocolatine du sud ouest");
		produitRepository.save(p2);
		List<Produit> list=produitRepository.findAllByTaille(TailleProduit.maxi);
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testFindAllByType() {
		Produit p = new Produit("chocolat1", TailleProduit.maxi, 3, TypeProduit.Viennoiserie, "une joli chocolatine du sud ouest");
		produitRepository.save(p);
		Produit p2 = new Produit("chocolat2", TailleProduit.maxi, 3, TypeProduit.Viennoiserie, "une joli chocolatine du sud ouest");
		produitRepository.save(p2);
		List<Produit> list=produitRepository.findAllByType(TypeProduit.Viennoiserie);
		assertFalse(list.isEmpty());
	}

}








