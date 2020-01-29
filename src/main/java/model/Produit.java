package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="produit")
@SequenceGenerator(name="seqProduit", sequenceName = "seq_produit", initialValue = 100, allocationSize = 1)

public class Produit {
	@Id
	@GeneratedValue(generator = "seqProduit", strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="libelle", nullable = false)
	@NotEmpty(message="champ obligatoire")
	private String libelle;
	@Column(name="taille", nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull(message ="champ obligatoire")
	private TailleProduit taille;
	@Column(name="prix", nullable = false)
	private double prix=0.1;
	@Column(name="type",length=25, nullable = false)
	@Enumerated(EnumType.STRING)
	@NotNull(message ="champ obligatoire")
	private TypeProduit type; 
	@Column(name="description")
	private String description; 
	@Column(name="photo")
	private String photo;
	@OneToMany(mappedBy = "id.produit")
	private Set<LigneCommande> ligneCommandes; 
	@Version
	private int version;
	
	
	
	
	public Produit() {
	}

	
	public Produit(String libelle, TailleProduit taille, double prix, TypeProduit type, String description) {
		this.libelle = libelle;
		this.taille = taille;
		this.prix = prix;
		this.type = type;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public TailleProduit getTaille() {
		return taille;
	}

	public void setTaille(TailleProduit taille) {
		this.taille = taille;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public TypeProduit getType() {
		return type;
	}

	public void setType(TypeProduit type) {
		this.type = type;
	}

	

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	} 



	public Set<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}


	public void setLigneCommandes(Set<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
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
		Produit other = (Produit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
	
}
