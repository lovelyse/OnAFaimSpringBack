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
import repositories.LigneCommandeRepository;




@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations= {"/application-context.xml"})
public class LigneCommandeRepositoryTest {

	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	
	@Test
	public void testInsertAndDelete(){
		Compte co = new Compte();
		Commande c=new Commande();
		c.setIdCom(5L);
		c.setCompte(co);
		Produit p=new Produit("chocolat1", TailleProduit.maxi, 3, TypeProduit.Viennoiserie, "une joli chocolatine du sud ouest");
		LigneCommandePK lcPK = new LigneCommandePK(c,p);
		LigneCommande lc = new LigneCommande(3,lcPK);
		System.out.println("-----------------------------------"+lc);
		ligneCommandeRepository.save(lc);
		System.out.println("--------------------after save");
		assertNotNull(ligneCommandeRepository.findById(lc.getId()));
		ligneCommandeRepository.delete(lc);
        Optional<LigneCommande> opt= ligneCommandeRepository.findById(lc.getId());
        assertFalse(opt.isPresent());
        System.out.println("--------------------end");
	}
	

}








