package testUnitaire;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Compte;
import model.Etat;
import model.TypeCompte;
import repositories.CompteRepository;
import service.CompteService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations= {"/application-context.xml"})
public class CompteRepositoryTest {

	@Autowired
	private CompteRepository compteRepository;
	private CompteService compteService;
		
	//@Test
	public void testInsertAndDelete(){
		Compte c= new Compte("Lete", "Lovelyse", "0664724623", "love@ya.fr", "mdp");
		compteRepository.save(c);
		assertNotNull(compteRepository.findById(c.getId()));
		compteRepository.delete(c);
		Optional<Compte> opt= compteRepository.findById(c.getId());
		assertFalse(opt.isPresent());
	}
	
	//@Test
	public void testFindByEmailAndMdp() {
		Compte c= new Compte("Lete", "Lovelyse", "0664724623", "love@ya.fr", "mdp");
		compteRepository.save(c);
		Optional opt=compteRepository.findByEmailAndMdp(c.getEmail(), c.getMdp());
		assertTrue(opt.isPresent());
	}
	
	//@Test
	public void testFindAllByType() {
		Compte c= new Compte("Lete", "Lovelyse", "0664724623", "love@ya.fr", "mdp");
		compteRepository.save(c);
		Compte c2= new Compte("Lete", "Sylvano", "0664724623", "sylvano@ya.fr", "mdp");
		compteRepository.save(c2);
		List<Compte> list=compteRepository.findAllByType(TypeCompte.client);
		assertFalse(list.isEmpty());
	}
	
	//@Test
	public void testfindAllByCompteEtat() {
		Compte c= new Compte("Lete", "Lovelyse", "0664724623", "love@ya.fr", "mdp");
		compteRepository.save(c);
		Compte c2= new Compte("Lete", "Sylvano", "0664724623", "sylvano@ya.fr", "mdp");
		compteRepository.save(c2);
		List<Compte> list=compteRepository.findAllByCompteEtat(Etat.W);
		assertFalse(list.isEmpty());
	}
	
	@Test
	public void testCheckConnect() {
		Compte c= new Compte("Lete", "Lovelyse", "0664724623", "love@ya.fr", "mdp");
		compteRepository.save(c);
		Boolean b=compteService.checkConnect(c);
		assertTrue(b.booleanValue());
	}

}
