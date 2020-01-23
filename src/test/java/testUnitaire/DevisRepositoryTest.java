package testUnitaire;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Compte;
import model.Devis;
import model.Etat;
import repositories.CompteRepository;
import repositories.DevisRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class DevisRepositoryTest {

	@Autowired
	private DevisRepository devisRepository; 
	@Autowired
	private CompteRepository compteRepository;
	
	
	@Test
	public void createDevis() {
		Compte c= new Compte("Lete", "Lovelyse", "0664724623", "love@ya.fr", "mdp");
		compteRepository.save(c);
		Devis d = new Devis("on s'en fou"); 
		d.setCompte(c);
		devisRepository.save(d); 
		assertNotNull(devisRepository.findById(d.getId())); 
		devisRepository.delete(d);
		Optional<Devis> opt= devisRepository.findById(c.getId());
		assertFalse(opt.isPresent());
	}
	
	//@Test 
	public void testfindAllByEtat() {
		Compte c1= new Compte("dai", "lilia", "0603116323", "dai@ya.fr", "mdp");
		compteRepository.save(c1);
		Devis d1 = new Devis("titi"); 
		devisRepository.save(d1); 
		List<Devis> list=devisRepository.findAllByEtat(Etat.W);
		assertFalse(list.isEmpty());
	}


	
}
