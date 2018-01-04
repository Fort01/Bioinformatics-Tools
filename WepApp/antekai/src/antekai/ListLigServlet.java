package antekai;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ListLigServlet")
public class ListLigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListLigServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			String x = request.getParameter("param");
			System.out.println("5555555555555555555555" + x );
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
	    	ListLigServletDao wer= new ListLigServletDao();
	    	List<Ligand> result = null;
	    	
		
			
			
			//String x = 	response.getWriter().write(request.getParameter("param"));
			try {
				result=wer.firstquery(x);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

				out.append("Results listed bellow");
				out.append("</br>");
				out.append("</br>");
				out.append("<table>");
				out.append("<tr><td>");
				out.append("<strong>Name</strong>");
				out.append("</td><td>");
				out.append("<strong>SMILE</strong>");
				out.append("</td><td>");
				out.append("<strong>Ki</strong>");
				out.append("</td><td>");
				out.append("</tr>");
			
				
				 for(Ligand an:result) 
				 {		
					 	out.append("<tr><td>");
					 	
					 	//System.out.println("8888888");
				
					//out.append("<form method=\"get\" action=\"..\\ListLigServlet\" >");
					
					out.append(an.getName() );
					 	//out.append("<a href=\"ListLigServlet?param="+ an.getName() + "\">" + an.getName() + "</a>");
					 	
					 	
					 	out.append("</td><td align:'left'>");
					
					out.append(an.getSmile());
					out.append("</td><td>");
					
					out.append(an.getKi());
					//out.append("<form method=\"get\" action=\"../antekai/ListLigServlet\" >");
					//out.append("<input type=\"submit\" value=\"see more\" >");
					//out.append("</form>");
					out.append("</td></tr>");
					
					
				 }
				 out.append("</table>");
				 out.append("</br>");
			
				 out.append("<a href=\"FILE/homepage.jsp\"><strong>Home</strong></a>");
			
				 
				 
				 
				 
				 
				 
				 
				 
			/*
			int columnCount=1;
			String a="";
			java.sql.ResultSetMetaData resultmd;
				
					resultmd = teliko.getMetaData();
				 columnCount=resultmd.getColumnCount();
				
				Object[] row= new Object[columnCount];
				out.append("<table>");
				while(teliko.next())
				{	
					out.append("<tr>");
					for(int i=1; i<=columnCount; i++)
					{
					  row[i-1]=teliko.getString(i);
					  a=teliko.getString(i) ;
						out.append("<td>");
						out.append(a);
						out.append("</td>");
					  
						out.append("</tr>");
					}
					
				}
				out.append("</table>");
			
					
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
