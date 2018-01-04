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

/**
 * Servlet implementation class AllReceptors
 */
@WebServlet("/AllReceptors")
public class AllReceptorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllReceptorsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		
		//AllLigands alignds = new AllLigands();
		AllReceptors rec = new AllReceptors();
		
		out.append(" ALL RECEPTORS IN LIG-AND-BASE db ARE LISTED HERE: " );
		out.append("</br> </br>");
		out.append(" <table id=recbox> " );
		out.append(" <tr> " );
		
		out.append(" <td align=\"left\"> " );
		out.append( "ID" );
		out.append(" </td> " );
		
		out.append(" <td align=\"center\"> " );
		out.append( "Name" );
		out.append(" </td> " );
		
		out.append(" <td align=\"right\"> " );
		out.append( "Unigene" );
		
		out.append("</tr>");
		
		
		for(Receptor a:rec.allReceptors(con))
		{
			//out.append(  ligand.getLigand_id() )	 );
			
			
			
			out.append(" <tr> " );
			
			out.append(" <td align=\"center\"> " );
			out.append( "###");//a.getReceptorID() );
			out.append(" </td> " );
			
			out.append(" <td align=\"center\"> " );
			out.append( a.getName() );
			
			out.append(" <td align=\"left\"> " );
			out.append( a.getUnigene() );
			
			out.append("</tr>");
			//out.append(  "</br>" );
		}
		
		out.append("</table>");
		
		out.append("<a href=\"FILE/homepage.jsp\"><strong>Home</strong></a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
