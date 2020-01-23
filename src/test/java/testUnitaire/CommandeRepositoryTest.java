package testUnitaire;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Commande;
import model.Compte;
import model.Etat;
import repositories.CommandeRepository;
import repositories.CompteRepository;
import repositories.ProduitRepository;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations= {"/application-context.xml"})
public class CommandeRepositoryTest {

	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private ProduitRepository produitRepository;
	
	//@Test
	public void testInsertAndDelete() {
		Compte c= new Compte("Lete", "Lovelyse", "0664724623", "love@ya.fr", "mdp");
		compteRepository.save(c);
		
		Commande com= new Commande();
		com.setCompte(c);
		com.setEval("pas bon");
		commandeRepository.save(com);
		assertNotNull(commandeRepository.findById(com.getId()));
		
		commandeRepository.delete(com);
		Optional<Commande> opt=commandeRepository.findById(com.getId());
		assertFalse(opt.isPresent());
	}
	
	@Test
	public void testfindAllByEtat() {
		Compte c= new Compte("Lete", "Lovelyse", "0664724623", "love@ya.fr", "mdp");
		compteRepository.save(c);
		
		Commande com= new Commande();
		com.setCompte(c);
		com.setEval("pas bon");
		commandeRepository.save(com);
		
		Commande com2= new Commande();
		com2.setCompte(c);
		com2.setEval("pas bon");
		commandeRepository.save(com2);
		
		List<Commande> list=commandeRepository.findAllByEtat(Etat.W);
		assertFalse(list.isEmpty());
	}

}
