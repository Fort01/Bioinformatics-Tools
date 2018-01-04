package antekai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Receptor_DAO 
{
	private static final String INSERT_receptor ="INSERT INTO receptor (name, unigene) VALUES(?,?)";
	
	
	public Receptor_DAO(Receptor recp) throws Exception
	{
		doit(recp);
	}
	
	public int getDBID(Receptor recp) throws Exception
	{
		String a = "SELECT receptor.receptor_id FROM receptor WHERE receptor.name='" + recp.getName()+"' AND receptor.unigene='" + recp.getUnigene()+"'";
		
		Connection con= this.getConn();
		//Statement statement = con.createStatement();
		PreparedStatement statement1 = con.prepareStatement(a);
		ResultSet rset = statement1.executeQuery();
		
		if(rset.next()) {
			 System.out.println(rset.getInt(1));

		}
		
		return rset.getInt((1));
		 
	}
	
		
	
	private void doit(Receptor recp)
	{ 
		
		try
		{
			
			Connection con= this.getConn();	
			//Statement statement = con.createStatement();
			PreparedStatement statement = con.prepareStatement(INSERT_receptor);
			statement.setString(1, recp.getName());
			statement.setString(2, recp.getUnigene());
			statement.executeUpdate();		
		} 
		catch (Exception e) {
			e.printStackTrace();
			
		}
	}
		//RequestDispatcher disp = getServletContext().getRequestDispatcher("/list.jsp");
	
	
	
	
	
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
