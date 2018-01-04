

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("/adminServlet")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String username = request.getParameter("name");
		String password = request.getParameter("code");
		System.out.println(username+password);
		//System.out.println("5555555555555555555555" + x );
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if( (password.equals("010203") && username.equals("niquitas") ) || (password.equals("champion") && username.equals("team") ) ) 
		{
		    out.append("Hello "+ username+ " ");
			out.append("</br>");			
			out.append("<a href=\"FILE/add.jsp\"><strong>Add a new entrie to Lig-and-Base database</strong></a>");
		    out.append("</br>");
			out.append("<a href=\"FILE/homepage.jsp\"><strong>Home</strong></a>");
		    
		}
		else
		{
		   
			out.append("<strong>ACCESS DENIED<strong>");
		    out.append("you dont have permission, contact the administrator to grand you access");
			out.append("</br>");	
			out.append("<a href=\"FILE/homepage.jsp\"><strong>Home</strong></a>");
		}     
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
