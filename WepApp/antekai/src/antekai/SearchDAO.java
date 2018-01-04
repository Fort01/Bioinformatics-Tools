package antekai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SearchDAO {
	

	
	public SearchDAO() 
	{
	  	System.out.println("ena search dao");
	}
		
	public List<Receptor> searchtoDB(String x) throws Exception 
	{
		String search ="select * from receptor where receptor.name like '%"+x+"%' or receptor.unigene like '%"+x+"%'";
		System.out.println(search);

		return listAll(search);
    }
	
	public List<Receptor> listAll(String search) throws SQLException
	{
		Connection con = null;
		List<Receptor> receptors = null;
		try 
		{
			con= this.getConn();
			Statement statement = con.createStatement();
			ResultSet set = statement.executeQuery(search);
			
			if(set.wasNull()){ System.out.println("wasNull");}
			receptors = new ArrayList<Receptor>();
			
			while(set.next()){	
				System.out.println("while-while");
				Receptor rec = new Receptor();
				
				rec.setReceptorID(set.getInt("receptor_id"));
				
				rec.setName(set.getString("name"));
				
				rec.setUnigene(set.getString("unigene"));
				
				System.out.println("tostring");
				System.out.println(rec.toString());
				
				receptors.add(rec);
			}
			return receptors;
		} 
		catch (Exception e) 
		{
			return null;		
		}
		finally 
		{
			
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	
	public Connection getConn() throws Exception
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://83.212.122.254:3306/travlos";
			String username="travlos";
			String password="travlos";
			
			System.out.println("found");
			
			
		Connection con=null;	
			con=DriverManager.getConnection(url, username, password);
			Statement statement= con.createStatement();
			
	       System.out.println("egine syndesh!");
	       return con;
		
		}
		catch (SQLException ee)
		{
			throw new RuntimeException("cannot connect the database!", ee);
		}
	
	
	

}
}
