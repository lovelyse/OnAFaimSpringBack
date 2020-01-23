package testUnitaire;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Devis;
import model.Etat;
import repositories.DevisRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-context.xml"})
public class DevisRepositoryTest {

	@Autowired
	private DevisRepository devisRepository; 
	
	
	@Test
	public void createDevis() {
		Devis d = new Devis();  
		assertNotNull(devisRepository.findById(null)); 
	}
	
	
	public void updateDevis() {}
	

	public void deleteDevis() {}	
}
