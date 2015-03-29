/**@author Maite AINCIBURU
 * 
 * 
 */
package core;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import persist.PersistKit;

public abstract class ListCategory {
	
	protected static ListCategory listCategory = null; 
	private ArrayList<CategoryProduct> listAllCategories = new ArrayList<CategoryProduct>(); 
	/**
	 * Constructeur
	 */
	public ListCategory(){
	}
	
	/**
	 * Accesseurs & Modificateurs
	 */
	public ArrayList<CategoryProduct> getListAllCategories() {
		return listAllCategories;
	}
	
	public void setListCategory(ArrayList<CategoryProduct> aListAllCategories){
		this.listAllCategories = aListAllCategories; 
	}
	
	
	/**
	 * Ajoute une categorie dans la liste des categories
	 * @param cat (CategoryProduct) : categorie a ajouter 
	 * 	 
	 * */
	public void add(CategoryProduct cat){
		listAllCategories.add(cat);
	}
	
	/**
	 * getInstance
	 * on instancie une ListCategorie dans un type de persistance
	 * @param persistType type de persistance
	 * @return une liste ListCategory
	 */
	public static ListCategory getInstance (int persistType){
		if (listCategory == null){
			listCategory = PersistKit.createKit(persistType).createListCategory(); 
		}
		return listCategory;
	}
	
	/**
	 * confirmCreationCategory
	 * @param category (String) la categorie a ajouter
	 * @param idParent (int) la categorie parent
	 * @return vrai si la categorie est cree dans la persistance, faux sinon
	 */
	public boolean confirmCreationCategory(String category, int idParent){
		if(verifyCategoryExist(category)){
			if(idParent == 0)
				insertCategoryWithNameJDBC(category);
			else
				insertCategoryWithNameAndSuperCategoryJDBC(category, idParent);
			return true;
		}
		else
			return false;
			
	}
	
	/**
	 * searchWithId
	 * recherche une categorie grace a un identifiant
	 * @param idcat (int) : identifiant de la categorie
	 * @return un CategoryProduct correspondant à l'identifiant de la categorie
	 */
	public CategoryProduct searchWithId(int idcat){
		CategoryProduct cat = null; 
		Iterator<CategoryProduct> it =  this.getListAllCategories().iterator();
		
		boolean find = false; 
		while ( it.hasNext() && !(find)) {
			cat=it.next();
			if(cat.getCategoryId() == idcat){
				find=true;
			}
		}
		return cat; 
	}

	/**searchNameWithId
	 * recherche le nom d'une categorie grace a un identifiant
	 * @param idcat (int) : identifiant de la categorie
	 * @return String : nom de la categorie correspondant à l'identifiant donné
	 */
	public String searchNameWithId(int idcat){
		CategoryProduct cat = null; 
		Iterator<CategoryProduct> it =  this.getListAllCategories().iterator();
		
		boolean find = false; 
		while ( it.hasNext() && !(find)) {
			if(it.next().getCategoryId() == idcat){
				find=true;
				cat = ((CategoryProduct) it);
			}
		}
		return cat.getCategoryName(); 
	}
	
	public abstract void getAllCategories();
	public abstract void insertCategoryWithNameJDBC(String cat) ; 
	public abstract void insertCategoryWithNameAndSuperCategoryJDBC(String catName, int catParent);
	public abstract void updateCategoryWithNameJDBC(int idCat, String catName) throws SQLException;
	public abstract void updateCategoryWithSuperCategoryJDBC(int idCat,  int catIdSuperCategory) throws SQLException; 
	public abstract void updateCategoryWithNameAndSuperCategoryJDBC(int idCat, String catName,  int catIdSuperCategory) throws SQLException;
	public abstract void deleteCategoryJDBC(int idCat) throws SQLException; 
	public abstract boolean verifyCategoryExist(String nameCat);
	public abstract ArrayList<String> getListCatNameJDBC(); 

}
