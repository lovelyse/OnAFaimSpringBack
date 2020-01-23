package testUnitaire;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Compte;
import repositories.CompteRepository;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations= {"/application-context.xml"})
public class CompteRepositoryTest {

	@Autowired
	private CompteRepository compteRepository;
		
	@Test
	public void testInsert(){
		Compte c= new Compte("Lete", "Lovelyse", "0664724623", "love@ya.fr", "mdp");
		compteRepository.save(c);
		assertNotNull(compteRepository.findById(c.getId()));
		compteRepository.deleteById(c.getId());;
		assertNull(compteRepository.findById(c.getId()));
	}
	
//	@Test
//	public void testDelete() {
//		compteRepository.deleteById(100L);
//		assertNull(compteRepository.findById(100));
//	}
	


}
