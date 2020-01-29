package testUnitaire;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Commande;
import model.Compte;
import model.LigneCommande;
import model.LigneCommandePK;
import model.Produit;
import model.TailleProduit;
import model.TypeProduit;
import repositories.CommandeRepository;
import repositories.CompteRepository;
import repositories.LigneCommandeRepository;
import repositories.ProduitRepository;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations= {"/application-context.xml"})
public class LigneCommandeRepositoryTest {

	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private CommandeRepository commandeRepository;
	
	@Autowired
	private ProduitRepository produitRepository;
	
	
	@Test
	public void testInsertAndDelete(){
		Compte co = new Compte();
		compteRepository.save(co);
		Commande c=new Commande();
		c.setCompte(co);
		commandeRepository.save(c);
		Produit p=new Produit("chocolat1", TailleProduit.Maxi, 3, TypeProduit.Viennoiserie, "une joli chocolatine du sud ouest");
		produitRepository.save(p);
		LigneCommandePK lcPK = new LigneCommandePK(c,p);
		LigneCommande lc = new LigneCommande(3,lcPK);
//		System.out.println("-----------------------------------"+lc);
		ligneCommandeRepository.save(lc);
//		System.out.println("--------------------after save");
		assertNotNull(ligneCommandeRepository.findById(lc.getId()));
		ligneCommandeRepository.delete(lc);
        Optional<LigneCommande> opt= ligneCommandeRepository.findById(lc.getId());
        assertFalse(opt.isPresent());
//        System.out.println("--------------------end");
	}
	

}








