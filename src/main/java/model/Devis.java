package model;

import java.util.Date;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;



@Entity
@Table(name="devis")
@SequenceGenerator(name="seqDevis",sequenceName="seq_devis",initialValue=100,allocationSize=1)
public class Devis {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqDevis")
	private Long id;
	@Lob
	@Column(name="eval")
	private String dEval;
	@Column(name="prix")
	private double prix;
	@Column(name="etat",length=15)
	@Enumerated(EnumType.STRING)
	private Etat etat=Etat.W;
	@Column(name="description",length=255)
	private String description;
	@Temporal(TemporalType.DATE)
	@Column(name="dateCommande")
	private Date date = new Date();
	@ManyToOne
	@JoinColumn(name="compte", foreignKey = @ForeignKey(name="compte_devis_fk"))
	private Compte compte;
	@Version
	private int version; 
	
	
	public Devis() {
	}

	
	public Devis(String description) {
		this.description = description;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getdEval() {
		return dEval;
	}


	public void setdEval(String dEval) {
		this.dEval = dEval;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}



	public Etat getEtat() {
		return etat;
	}


	public void setEtat(Etat etat) {
		this.etat = etat;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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
		Devis other = (Devis) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
}
