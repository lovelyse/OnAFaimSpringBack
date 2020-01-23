package model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


@Entity
@Table(name="commande")
@SequenceGenerator(name="seqCommande",sequenceName="seq_commande",initialValue=100,allocationSize=1)
public class Commande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqCommande")
	private Long id; 
	@Column(name="eval",length=255)
	private String eval; 
	@Enumerated(EnumType.STRING)
	@Column(name="etat",length=1)
	private Etat etat=Etat.W; // "en_attente" par défaut
	@Temporal(TemporalType.DATE)
	@Column(name="dateCommande")
	private Date date;
	@ManyToOne
	@JoinColumn(name="compte_id", foreignKey = @ForeignKey(name="commande_compte_fk"))
	private Compte compte;
	@OneToMany (mappedBy= "id.commande") //PAS UNE ERREUR
	private Set<LigneCommande> panier;
	@Version
	private int version;

	

	public Commande() {
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEval() {
		return eval;
	}


	public void setEval(String eval) {
		this.eval = eval;
	}


	public Etat getEtat() {
		return etat;
	}


	public void setEtat(Etat etat) {
		this.etat = etat;
	}



	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Compte getCompte() {
		return compte;
	}


	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	public Set<LigneCommande> getPanier() {
		return panier;
	}


	public void setPanier(Set<LigneCommande> panier) {
		this.panier = panier;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	

	
	
	

}