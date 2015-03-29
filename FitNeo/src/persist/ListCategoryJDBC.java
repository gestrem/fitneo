/**@author Maite AINCIBURU **/
package persist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import core.CategoryProduct;
import core.ListCategory;

public class ListCategoryJDBC extends ListCategory {
	private JdbcConnection jdbc = null;

	public ListCategoryJDBC(){
		jdbc = new JdbcConnection();
	}
	
	/**
     * Methode getAllCategories() 
     * On recupere les categories : un ensemble (int idCat, string categoryLabel, int idSuperCategorie)
	 * on charge la liste des categories : liste de (int idCat, string categoryLabel, CategorieProduct superCategorie 
	 * */ 
	
	public void getAllCategories(){
		jdbc.openConnection(); 
		ResultSet rs = null; 
		
		try{
			ArrayList<CategoryProduct> listAllCategories = new ArrayList<CategoryProduct>();

			String query = "SELECT id_category, categoryLabel, id_super_category FROM categoryProduct ";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				  int id = rs.getInt(1);
			      //System.out.println("id=" + id);
			      String name = rs.getString(2);
			      //System.out.println("name=" + name);
			      int idParent = rs.getInt(3);
			      //System.out.println("id Parent=" + idParent);
			      if (rs.wasNull()) {
					listAllCategories.add(new CategoryProduct(id,name)); 
					}
				else {
					listAllCategories.add(new CategoryProduct(id,name, this.searchWithId(idParent))); 
				}
			}	
			this.setListCategory(listAllCategories);
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
	}
	
	/**
	 * insertCategory WithNameJDBC
	 * @param catName
	 * insere une categorie dans la BD avec un nom et une categorie Parent nulle
	 * 
	 */
	public void insertCategoryWithNameJDBC(String catName){

		jdbc.openConnection();
		try{
			//String query = "INSERT INTO categoryProduct (categoryLabel, id_super_category)values ('" +cat.getCategoryName()+ "', "+cat.getSuperCategoryId()+")"; 
			String query = "INSERT INTO categoryProduct (categoryLabel)values ('" +catName+ "')"; 
			jdbc.executeRequest(query);
		}
		catch(Exception e){
			//System.out.println("Duplicate entry");
		}
		jdbc.close();
	
	}
	
	/**
	 * insertCategory WithNameAndSuperCategoryJDBC
	 * @param catName (string)
	 * @param catParent (int)
	 * insere une categorie dans la BDavec un Nom et une Categorie Parent nulle
	 * 
	 */
	public void insertCategoryWithNameAndSuperCategoryJDBC(String catName, int catParent){

		jdbc.openConnection();
		String query = "INSERT INTO categoryProduct (categoryLabel, id_super_category)values ('" +catName+ "', "+catParent+")"; 
		jdbc.executeRequest(query);
		jdbc.close();
	
	}
	/**
	 * updateCategoryWithNameJDBC
	 * @param idCat (int)
	 * @param catName (string)
	 * met a jour une categorie dans la BD avec un nouveau nom
	 */
	public void updateCategoryWithNameJDBC(int idCat, String catName) throws SQLException{

		jdbc.openConnection();
		String query = "UPDATE categoryProduct SET categoryLabel= '"+catName+"' WHERE id_category ='"+idCat+"'"; 
		jdbc.executeRequest(query);
		jdbc.close();
	
	}
	
	/**
	 * updateCategoryWithSuperCategoryJDBC
	 * @param idCat (int)
	 * @param catIdSuperCategory (int)
	 * met a jour une categorie dans la BD avec une nouvelle categorie Parent
	 */
	public void updateCategoryWithSuperCategoryJDBC(int idCat, int catIdSuperCategory) throws SQLException{

		jdbc.openConnection();
		String query = "UPDATE categoryProduct SET id_super_category= '"+catIdSuperCategory+"' WHERE id_category ='"+idCat+"'"; 
		jdbc.executeRequest(query);
		jdbc.close();
	
	}
	
	/**
	 * updateCategoryWithNameAndSuperCategoryJDBC
	 * @param idCat (int)
	 * @param catName (string)
	 * @param catIdSuperCategory (int)
	 * met a jour une categorie dans la BD avec un nouveau nom & une nouvelle categorie Parent
	 */
	public void updateCategoryWithNameAndSuperCategoryJDBC(int idCat, String catName,  int catIdSuperCategory) throws SQLException{
		jdbc.openConnection();
		String query = "UPDATE categoryProduct SET categoryLabel= '"+catName+"',id_super_category= '"+catIdSuperCategory+"' WHERE id_category ='"+idCat+"'"; 
		jdbc.executeRequest(query);
		jdbc.close();
	

	}
	
	/**
	 * deleteCategoryJDBC
	 * @param idCat (int)
	 * supprime une categorie dans la BD
	 */
	public void deleteCategoryJDBC(int idCat) throws SQLException{
		jdbc.openConnection();
		String query = "DELETE FROM categoryProduct WHERE id_category ='"+idCat+"'"; 
		jdbc.executeRequest(query);
		jdbc.close();
	

	}
	

	/**
	 * verifyCategoryExist(String nameCat)
	 * @param nameCat
	 * cherche si la categorie est presente dans la BD
	 * @return vrai si la categorie existe, faux sinon
	 */
	public boolean verifyCategoryExist(String nameCat) {
		jdbc.openConnection();
		boolean result = true;
		try{
			String query ="SELECT categoryLabel from categoryProduct WHERE categoryLabel ='" + nameCat + "'";
			jdbc.executeRequest(query);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(jdbc.nbResponse() != 0)
			result = false;
		jdbc.close();
		return result;
	}
	
	/**
     * Methode getListCatNameJDBC 
     * @return les categories de la BD sous forme de liste de string 
     * 
     */
	public ArrayList<String> getListCatNameJDBC (){
		 
		ArrayList<String> categories = new ArrayList<String>();
		jdbc.openConnection(); 
		ResultSet rs = null; 
		try{
			String query = "SELECT id_category, categoryLabel FROM categoryProduct";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				int catId = rs.getInt(1);
			    //System.out.println("category id =" + catId);
			    String categoryLabel = rs.getString(2);
			    //System.out.println(" category label =" + categoryLabel);
			    categories.add(Integer.toString(catId)+" "+categoryLabel); 
			 }
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		jdbc.close();
		return categories;
	}
}
