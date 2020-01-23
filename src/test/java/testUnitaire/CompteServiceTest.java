package testUnitaire;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Compte;
import repositories.CompteRepository;
import service.CompteService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations= {"/application-context.xml"})
public class CompteServiceTest {

	@Autowired
	private CompteService compteService;
	@Autowired
	private CompteRepository compteRepository;
	
	@Test
	public void testCheckConnect() {
		Compte c= new Compte("Lete", "Lovelyse", "0664724623", "love@ya.fr", "mdp");
		compteRepository.save(c);
		Boolean b=compteService.checkConnect(c);
		assertTrue(b.booleanValue());
	}

}
