package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Devis;
import repositories.DevisRepository;

@Service
public class DevisService {

	@Autowired
	private DevisRepository devisRepository; 
	
	
	public boolean save (Devis d) {
		Devis devisBase = null; 
		
		if(d.getId()!=null) {
			Optional<Devis> opt = devisRepository.findById(d.getId()); 
			if(opt.isPresent()) {
				devisBase=opt.get(); 
				devisBase.setDate((d.getDate()!=null) ? d.getDate():devisBase.getDate());
				devisBase.setPrix((d.getPrix()!=0) ? d.getPrix():devisBase.getPrix());
				devisBase.setdEtat((d.getdEtat()!=null) ? d.getdEtat():devisBase.getdEtat());
				devisBase.setDescription((d.getDescription()!=null) ? d.getDescription():devisBase.getDescription());
				devisBase.setDate((d.getDate()!=null) ? d.getDate():devisBase.getDate());
				devisBase.setCompte((d.getCompte()!=null) ? d.getCompte():devisBase.getCompte());
				devisBase.setVersion((d.getVersion()!=0) ? d.getVersion():devisBase.getVersion());
				devisRepository.save(devisBase);
				return true; 
			} 
		}else {
				boolean erreur = false; 
				if(d.getId()==null) {
					erreur = true; 
				}
				if(d.getDescription()==null) {
					erreur = true; 
				}
				if(d.getDate()==null) {
					erreur = true; 
				}
				if(d.getCompte()==null) {
					erreur = true; 
				}
				if(d.getVersion()==0) {
					erreur = true; 
				}
				if(!erreur) {
					devisRepository.save(d); 
					return true; 
				}
			}
		return false;
	}
	
	
	
	
}
