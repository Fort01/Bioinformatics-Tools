package antekai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class ListLigServletDao {

	
	
	public ListLigServletDao() 
	{
	
	}

	public List<Ligand> firstquery(String click) throws Exception 
	{  
		String first="select ligand.*, interaction.ki from receptor	inner join interaction on interaction.recepid=receptor.receptor_id inner join ligand on ligand.ligand_id=interaction.ligid where receptor.name='"+ click + "'" ;
		System.out.println(first);
		
		Connection con= this.getConn();
		List<Ligand> ligands = null;
		
		
		PreparedStatement statement= (PreparedStatement) con.prepareStatement(first);
		ResultSet neo= statement.executeQuery();
		
		neo.next();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@" + neo.getInt(1));
	   	//ResultSet a = secondquery(neo.getInt(1),con);
	   	if(neo.wasNull()) {System.out.println("htan adio");}
		//con.close();
	   	ligands = new ArrayList<Ligand>();
	   	
	   	while(neo.next())
	   	{	
			System.out.println("while-while");
			Ligand lig = new Ligand();
			
			lig.setLigand_id(neo.getInt("ligand_id"));
			//rec.setReceptorID(.getInt("receptor_id"));
			lig.setName(neo.getString("name"));
			//rec.setName(set.getString("name"));
			lig.setSmile(neo.getString("SMILE"));
			//rec.setUnigene(set.getString("unigene"));
			lig.setKi(neo.getDouble("ki"));
			
			
			System.out.println("tostring");
			//System.out.println(rec.toString());
			
			ligands.add(lig);
			//receptors.add(rec);
		}
	   	
		return ligands;
	}
	
	/*
	public ResultSet secondquery(int rid, Connection con) throws SQLException {
		
		String second="select interaction.recepid from interaction where interaction.recepid='"+ rid+"'";
		System.out.println(second);
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(second);
        ResultSet sec= statement.executeQuery();
		
        sec.next();
        System.out.println(sec.getInt(1));
	   	return thirdquery(sec.getInt(1),con);
	}

	private ResultSet thirdquery(int int1, Connection con) throws SQLException {
		
		String third="select interaction.ligid from interaction where interaction.recepid='"+int1+"'";
		System.out.println(third);
		
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(third);
        ResultSet drei= statement.executeQuery();
		
        drei.next();
        System.out.println(drei.getInt(1));
	   	return fourthquery(drei.getInt(1),con);	
	}
	
	

	private ResultSet fourthquery(int int1, Connection con) throws SQLException {
		
		String vier="select ligand.ligand_id from ligand where ligand.ligand_id='"+int1+"'";
		System.out.println(vier);
		
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(vier);
        ResultSet fourth= statement.executeQuery();
		
        fourth.next();
        System.out.println(fourth.getInt(1));
	   	return fifthquery(fourth.getInt(1),con);	
	}

	private ResultSet fifthquery(int int1, Connection con) throws SQLException {
		String five="select * from ligand where ligand.ligand_id='"+int1+"'";
		System.out.println(five);
		
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(five);
        ResultSet fifth= statement.executeQuery();
        
        
      	return fifth;	
		*/
	

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
