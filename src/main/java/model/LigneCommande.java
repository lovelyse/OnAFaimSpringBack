package model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
@Table(name="ligne_commande")
public class LigneCommande {
	
	@Size(min=0, max=100)
	@Column(name="quantity", length=5)
	private int qte;
	
	@EmbeddedId
	private LigneCommandePK id; 
	
	@Version
	private int version;

	public LigneCommande() {
	}

	public LigneCommande(int qte, LigneCommandePK id) {
		this.qte = qte;
		this.id = id;
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
		LigneCommande other = (LigneCommande) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public LigneCommandePK getId() {
		return id;
	}

	public void setId(LigneCommandePK id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	
	
}
