package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Produit;
import repositories.ProduitRepository;

@Service
public class ProduitService {

	@Autowired
	private ProduitRepository produitRepository;
	
	public boolean save(Produit c) { 
		Produit produitBase=null;
		
		if(c.getId()!=null) {
			//update d'un Produit
			Optional<Produit> opt= produitRepository.findById(c.getId());
			if(opt.isPresent()) {
				produitBase=opt.get();
				produitBase.setId((c.getId()!=null)?c.getId():produitBase.getId());
				produitBase.setDescription((c.getDescription()!=null)?c.getDescription():produitBase.getDescription());
				produitBase.setLibelle((c.getLibelle()!=null)?c.getLibelle():produitBase.getLibelle());
				produitBase.setLigneCommandes((c.getLigneCommandes()!=null)?c.getLigneCommandes():produitBase.getLigneCommandes());
				produitBase.setPhoto((c.getPhoto()!=null)?c.getPhoto():produitBase.getPhoto());
				produitBase.setPrix((c.getPrix()!=0)?c.getPrix():produitBase.getPrix());
				produitBase.setTaille((c.getTaille()!=null)?c.getTaille():produitBase.getTaille());
				produitBase.setType((c.getType()!=null)?c.getType():produitBase.getType());
				produitBase.setVersion((c.getVersion()!=0)?c.getVersion():produitBase.getVersion());
				
				produitRepository.save(produitBase);
				return true;
			}
		}
		else {
			//création d'un Produit
			boolean erreur=false;
			if(c.getId()==null) {
				erreur=true;
			}
			if(c.getDescription()==null) {
				erreur=true;
			}
			if(c.getLibelle()==null) {
				erreur=true;
			}
			if(c.getLigneCommandes()==null) {
				erreur=true;
			}
			if(c.getPhoto()==null) {
				erreur=true;
			}
			if(c.getPrix()==0) {
				erreur=true;
			}
			if(c.getTaille()==null) {
				erreur=true;
			}
			if(c.getType()==null) {
				erreur=true;
			}
			if(c.getVersion()==0) {
				erreur=true;
			}
			if(!erreur) {
				produitRepository.save(c);
				return true;
			}
		}
		return false;
	}
	

}
