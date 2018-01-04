package antekai;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSetMetaData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import add.Ligand_DAO;

@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Search() 
    {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    
		String x = request.getParameter("receptor");
	//	List <Receptor> set = new ArrayList<>();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
       
		
			SearchDAO ser= new SearchDAO();
	        
	        System.out.println("egine erothma:" + x);
	        List<Receptor> result=null;
			try {
				result = ser.searchtoDB(x);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				e.printStackTrace();
			}
	       
		   
				
					System.out.println("333333333333333333333");

	
					out.append("Results listed bellow");
					out.append("</br>");
					out.append("</br>");
					out.append("<table>");
					out.append("<tr><td>");
					out.append("<strong>Name</strong>");
					out.append("</td><td>");
					out.append("<strong>Unigene</strong>");
					out.append("</td>");
					out.append("</tr>");
					
			
      	 for(Receptor an:result) 
      	 {		
      		 	out.append("<tr><td>");
      		 	
      		 	//System.out.println("8888888");
			
				//out.append("<form method=\"get\" action=\"..\\ListLigServlet\" >");
				
				//out.append(an.getName() );
      		 	out.append("<a href=\"ListLigServlet?param="+ an.getName() + "\">" + an.getName() + "</a>");
      		 	
      		 	
      		 	out.append("</td><td>");
				
				out.append(an.getUnigene());
				//out.append("</td><td>");
				
				//out.append("<form method=\"get\" action=\"../antekai/ListLigServlet\" >");
				//out.append("<input type=\"submit\" value=\"see more\" >");
				//out.append("</form>");
				out.append("</td></tr>");
				
				
		}
      	 out.append("</table>");
      	 out.append("</br>");
	
      	 out.append("<a href=\"FILE/homepage.jsp\"><strong>Home</strong></a>");
		}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
