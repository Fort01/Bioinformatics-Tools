package add;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;



import java.util.*;
import antekai.Ligand;
import antekai.Receptor;

public class Ligand_DAO 
{
	
	private static final String INSERT_ligand ="INSERT INTO ligand (name, smile) VALUES(?,?)";

	
	public Ligand_DAO(Ligand ligand) throws Exception
	{ 
		
		try
		{
			
		Connection con= this.connectToDb();
		
		
		
			//Statement statement = con.createStatement();
			PreparedStatement statement = con.prepareStatement(INSERT_ligand);
			statement.setString(1, ligand.getName());
			statement.setString(2, ligand.getSmile());
			
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
	
	public int getDBID(Ligand lig) throws Exception
	{
		String a = "SELECT ligand.ligand_id FROM ligand WHERE ligand.name='"+lig.getName()+"' AND ligand.SMILE='"+lig.getSmile()+"'";
		System.out.println(a);
		
		Connection con= this.connectToDb();
		//Statement statement = con.createStatement();
		PreparedStatement statement1 = con.prepareStatement(a);
		ResultSet rset = statement1.executeQuery();
		
		if(rset.next()) {
			 System.out.println(rset.getInt(1));

		}
		
		return rset.getInt((1));
		
	}
	
	
	
}
  




