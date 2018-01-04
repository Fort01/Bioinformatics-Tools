package antekai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Ki_DAO 
{
	private static final String INSERT_interaction ="INSERT INTO interaction (recepid,ligid,ki) VALUES(?,?,?)";
	
	
	public Ki_DAO(Double k,int ligID, int recID) throws Exception
	{ 
		
		try
		{
			
		Connection con= this.connectToDb();
		
		   //Statement statement = con.createStatement();
			PreparedStatement statement = con.prepareStatement(INSERT_interaction);
			
			statement.setInt(1,recID);
			statement.setInt(2,ligID);
			statement.setDouble(3,k);
			
			
			
			statement.executeUpdate();
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		}
		//RequestDispatcher disp = getServletContext().getRequestDispatcher("/list.jsp");
	
	public Connection connectToDb() throws Exception
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
