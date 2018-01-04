package antekai;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AllLigands 
{
	private static final String LIST_ALL_LIGANDS = "SELECT * FROM ligand";
	//private static ConnectionFactory factory;
	
	

	public List<Ligand> allLigands(Connection conn)
	{
			//Connection conn = null;
			List<Ligand> allLigandsList = null;
			try 
			{
				//conn = factory.getConnection(); //FromPool();
				Statement statement = conn.createStatement();
				ResultSet set = statement.executeQuery(LIST_ALL_LIGANDS);
				allLigandsList = new ArrayList<Ligand>();
				while (set.next())
				{
					Ligand lig = new Ligand();
					lig.setName(set.getString("name"));
					lig.setLigand_id(set.getInt("ligand_id"));
					lig.setSmile(set.getString("SMILE"));
					allLigandsList.add(lig);				}
				return allLigandsList;
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