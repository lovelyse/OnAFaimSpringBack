package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Personne;
import repositories.PersonneRepository;

@Service //=bean ==>c'est cette classe qui g�re tous les traitements que l'on veut faire avec personne ==>COUCHE METIER
public class PersonneService {

		@Autowired
		private PersonneRepository personneRepository;
			
		public boolean save(Personne p) { // save~update met � jour l'objet mais /!\Tous ce qui n'est pas positionner = null ==>il faut modifier un objet complet
			Personne personneBase=null;
			
			if(p.getId()!=null) {
				//update d'une personne
				Optional<Personne> opt= personneRepository.findById(p.getId());
				if(opt.isPresent()) {
					personneBase=opt.get(); //get l'optional
					//la ligne suivante doit �tre r�p�t�e pour tous les attributs
					personneBase.setPrenom((p.getPrenom()!=null)?p.getPrenom():personneBase.getPrenom()); //regarder si l'objet est non null, si oui, je r�cup�re celui que je viens de modifier, sinon je r�cup�re ce que j'ai en base
					personneRepository.save(personneBase);
				}
			}else {
				//cr�ation d'une personne
				boolean erreur=false;
				if(p.getPrenom()==null) {
					erreur=true;
				}
				if(p.getNom()==null) {
					erreur=true;
				}
				if(!erreur) {
					personneRepository.save(p);
				}
			}
			return false;
		}
}
