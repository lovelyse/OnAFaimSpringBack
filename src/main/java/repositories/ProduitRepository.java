package dao;

import java.util.List;

import model.Produit;
import model.TailleProduit;
import model.TypeProduit;

public interface DAOProduit extends DAOGeneric<Produit,Long> {
	
	public List<Produit> findBySize(TailleProduit size); 
	public List<Produit> findByType(TypeProduit type); 

	
	
}
