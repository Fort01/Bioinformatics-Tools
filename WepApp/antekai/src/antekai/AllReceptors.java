package antekai;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AllReceptors 
{
	private static final String LIST_ALL_RECEPTORS = "SELECT * FROM receptor";
	//private static ConnectionFactory factory;
	
	

	public List<Receptor> allReceptors(Connection conn)
	{
			//Connection conn = null;
			List<Receptor> allReceptorsList = null;
			
			try 
			{
			//conn = factory.getConnection(); //FromPool();
			Statement statement = conn.createStatement();
			ResultSet set = statement.executeQuery(LIST_ALL_RECEPTORS);
			allReceptorsList = new ArrayList<Receptor>();
			
			while (set.next())
			{
				Receptor rec = new Receptor();
				rec.setReceptorID(set.getInt("receptor_id"));
				rec.setName(set.getString("name"));	
				rec.setUnigene(set.getString("unigene"));
				allReceptorsList.add(rec);				}
				return allReceptorsList;
			} 
			catch (SQLException e) 
			{
				return null;		
			}
			finally 
			{
				try 
				{
					conn.close();
					System.out.println("connection closed");
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
	
	
}