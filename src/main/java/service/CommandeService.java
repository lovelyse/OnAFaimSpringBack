package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Commande;
import repositories.CommandeRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepository;
	
	public boolean save(Commande c) { 
		Commande commandeBase=null;
		
		if(c.getId()!=null) {
			//update d'une commande
			Optional<Commande> opt= commandeRepository.findById(c.getId());
			if(opt.isPresent()) {
				commandeBase=opt.get();
				commandeBase.setId((c.getId()!=null)?c.getId():commandeBase.getId());
				commandeBase.setEval((c.getEval()!=null)?c.getEval():commandeBase.getEval());
				commandeBase.setEtat((c.getEtat()!=null)?c.getEtat():commandeBase.getEtat());
				commandeBase.setDate((c.getDate()!=null)?c.getDate():commandeBase.getDate());
				commandeBase.setCompte((c.getCompte()!=null)?c.getCompte():commandeBase.getCompte());
				commandeBase.setVersion((c.getVersion()!=0)?c.getVersion():commandeBase.getVersion());
				
				commandeRepository.save(commandeBase);
				return true;
			}
		}else {
			//création d'une commande
			boolean erreur=false;
			if(c.getId()==null) {
				erreur=true;
			}
			if(c.getEtat()==null) {
				erreur=true;
			}
			if(c.getDate()==null) {
				erreur=true;
			}
			if(c.getCompte()==null) {
				erreur=true;
			}
			if(c.getVersion()==0) {
				erreur=true;
			}
			if(!erreur) {
				commandeRepository.save(c);
				return true;
			}
		}
		return false;
	}
	
}
