package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Compte;
import repositories.CompteRepository;

@Service
public class CommandeService {

	@Autowired
	private CompteRepository compteRepository;
	
	public boolean save(Compte c) { 
		Compte compteBase=null;
		
		if(c.getId()!=null) {
			//update d'une compte
			Optional<Compte> opt= compteRepository.findById(c.getId());
			if(opt.isPresent()) {
				compteBase=opt.get();
				compteBase.setId((c.getId()!=null)?c.getId():compteBase.getId());
				compteBase.setNom((c.getNom()!=null)?c.getNom():compteBase.getNom());
				compteBase.setPrenom((c.getPrenom()!=null)?c.getPrenom():compteBase.getPrenom());
				compteBase.setNumero((c.getNumero()!=null)?c.getNumero():compteBase.getNumero());
				compteBase.setEmail((c.getEmail()!=null)?c.getEmail():compteBase.getEmail());
				compteBase.setMdp((c.getMdp()!=null)?c.getMdp():compteBase.getMdp());
				compteBase.setType((c.getType()!=null)?c.getType():compteBase.getType());
				compteBase.setCompteEtat((c.getCompteEtat()!=null)?c.getCompteEtat():compteBase.getCompteEtat());
				compteBase.setDateCreation((c.getDateCreation()!=null)?c.getDateCreation():compteBase.getDateCreation());
				compteBase.setVersion((c.getVersion()!=0)?c.getVersion():compteBase.getVersion());
				
				compteRepository.save(compteBase);
				return true;
			}
		}else {
			//création d'une compte
			boolean erreur=false;
			if(c.getId()==null) {
				erreur=true;
			}
			if(c.getNom()==null) {
				erreur=true;
			}
			if(c.getPrenom()==null) {
				erreur=true;
			}
			if(c.getNumero()==null) {
				erreur=true;
			}
			if(c.getEmail()==null) {
				erreur=true;
			}
			if(c.getMdp()==null) {
				erreur=true;
			}
			if(c.getType()==null) {
				erreur=true;
			}
			if(c.getCompteEtat()==null) {
				erreur=true;
			}
			if(c.getDateCreation()==null) {
				erreur=true;
			}
			if(c.getVersion()==0) {
				erreur=true;
			}
			if(!erreur) {
				compteRepository.save(c);
				return true;
			}
		}
		return false;
	}
	
	public boolean checkConnect(Compte c) {
		if(c.getEmail()!=null && c.getMdp()!=null) {
			Optional<Compte> opt= compteRepository.findByEmailAndMdp(c.getEmail(), c.getMdp());
			if(opt.isPresent()) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}
