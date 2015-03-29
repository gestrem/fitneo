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
	
	/* On recupere toutes les categories cad un ensemble de (int idCat, string categoryLabel, int idSuperCategorie)
	 * pour instancier une categorie de type CategorieProduct, il nous faut (int idCat, string categoryLabel, CategorieProduct superCategorie 
	 * si la SuperCategorie n'est pas nulle on utilise l'int idSuperCategorie pour acceder a l'instance de CategoryProduct grace a la methode searchWithId
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
			      System.out.println("id=" + id);
			      String name = rs.getString(2);
			      System.out.println("name=" + name);
			      int idParent = rs.getInt(3);
			      System.out.println("id Parent=" + idParent);
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
	
	
	public void insertCategoryWithNameJDBC(String catName){

		jdbc.openConnection();
		ResultSet rs = null; 
		try{
			//String query = "INSERT INTO categoryProduct (categoryLabel, id_super_category)values ('" +cat.getCategoryName()+ "', "+cat.getSuperCategoryId()+")"; 
			String query = "INSERT INTO categoryProduct (categoryLabel)values ('" +catName+ "')"; 
			jdbc.executeRequest(query);
		}
		catch(Exception e){
			System.out.println("Duplicate entry");
		}
		jdbc.close();
	
	}
	
	public void insertCategoryWithNameAndSuperCategoryJDBC(String catName, int catParent){

		jdbc.openConnection();
		ResultSet rs = null; 
		
		String query = "INSERT INTO categoryProduct (categoryLabel, id_super_category)values ('" +catName+ "', "+catParent+")"; 
		jdbc.executeRequest(query);
		jdbc.close();
	
	}
	public void updateCategoryWithNameJDBC(int idCat, String catName) throws SQLException{

		jdbc.openConnection();
		ResultSet rs = null; 
		
		String query = "UPDATE categoryProduct SET categoryLabel= '"+catName+"' WHERE id_category ='"+idCat+"'"; 
		jdbc.executeRequest(query);
		jdbc.close();
	
	}
	
	public void updateCategoryWithSuperCategoryJDBC(int idCat, int catIdSuperCategory) throws SQLException{

		jdbc.openConnection();
		ResultSet rs = null; 
		
		
		String query = "UPDATE categoryProduct SET id_super_category= '"+catIdSuperCategory+"' WHERE id_category ='"+idCat+"'"; 
		jdbc.executeRequest(query);
		jdbc.close();
	
	}
	
	public void updateCategoryWithNameAndSuperCategoryJDBC(int idCat, String catName,  int catIdSuperCategory) throws SQLException{
		jdbc.openConnection();
		ResultSet rs = null; 
		
		
		String query = "UPDATE categoryProduct SET categoryLabel= '"+catName+"',id_super_category= '"+catIdSuperCategory+"' WHERE id_category ='"+idCat+"'"; 
		jdbc.executeRequest(query);
		jdbc.close();
	

	}
	
	public void deleteCategoryJDBC(int idCat) throws SQLException{
		jdbc.openConnection();
		ResultSet rs = null; 
		
		
		String query = "DELETE FROM categoryProduct WHERE id_category ='"+idCat+"'"; 
		jdbc.executeRequest(query);
		jdbc.close();
	

	}
	

	@Override
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
	
	public ArrayList<String> getListCatNameJDBC (){
		 
		ArrayList<String> categories = new ArrayList<String>();
		jdbc.openConnection(); 
		ResultSet rs = null; 
		
		try{
			
			String query = "SELECT id_category, categoryLabel FROM categoryProduct";
			jdbc.executeRequest(query);
			while ((rs = jdbc.fetchArray()) != null) {
				int catId = rs.getInt(1);
			    System.out.println("category id =" + catId);
			    String categoryLabel = rs.getString(2);
			    System.out.println(" category label =" + categoryLabel);
	
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
