package antekai;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	public MyFirstServlet()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("found");			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("not");
		}
		
		String url= "jdbc:mysql://83.212.122.254:3306/travlos";
		String username="travlos";
		String password="travlos";
		
		Connection con=null;
		 
		try
		{
			con=DriverManager.getConnection(url, username, password);
			//con=DriverManagerConnectionFactory.getInstance(true);
	        System.out.println("egine syndesh!");
		}
		catch(SQLException e)
		{
			System.out.println("mh syndesh");
		}
		
		
		AllLigands alignds = new AllLigands();
		
		out.append(" ALL LIGANDS IN LIG-AND-BASE db ARE LISTED HERE: " );
		out.append("</br> </br>");
		out.append(" <table id=ligbox> " );
		out.append(" <tr> " );
		
		out.append(" <td align=\"left\"> " );
		out.append( "<strong>ID</strong>" );
		out.append(" </td> " );
		
		out.append(" <td align=\"left\"> " );
		out.append( "<strong>Name</strong>" );
		out.append(" </td> " );
		
		out.append(" <td align=\"right\"> " );
		out.append( "<strong>SMILE</strong>" );
		
		out.append("</tr>");
		
		
		for(Ligand ligand:alignds.allLigands(con))
		{
			//out.append(  ligand.getLigand_id() )	 );
			
			
			
			out.append(" <tr> " );
			
			out.append(" <td align=\"left\"> " );
			out.append( "###" ); //ligand.getLigand_id() );
			out.append(" </td> " );
			
			
			out.append(" <td align=\"left\"> " );
			out.append( ligand.getName() );
			out.append(" </td> " );
			
			out.append(" <td align=\"right\"> " );
			out.append( ligand.getSmile() );
			
			out.append("</tr>");
			//out.append(  "</br>" );
		}
		
		out.append("</table>");
		
		out.append("<a href=\"FILE/homepage.jsp\"><strong>Home</strong></a>");
	}
	
	
	
	
	
}
