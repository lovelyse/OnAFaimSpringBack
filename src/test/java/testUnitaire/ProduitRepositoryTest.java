package testUnitaire;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Compte;
import model.Produit;
import model.TailleProduit;
import model.TypeProduit;
import repositories.CompteRepository;
import repositories.ProduitRepository;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations= {"/application-context.xml"})
public class ProduitRepositoryTest {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Test
	public void testInsert(){
		System.out.println("---------------------------------------- dans le test insert");
		Produit p = new Produit("choco", TailleProduit.maxi, 3, TypeProduit.Viennoiserie, "une joli chocolatine du sud ouest");
		produitRepository.save(p);
		assertNotNull(produitRepository.findById(p.getId()));
//		produitRepository.delete(p);
//        Optional<Produit> opt= produitRepository.findById(p.getId());
//        assertFalse(opt.isPresent());
	}

}



