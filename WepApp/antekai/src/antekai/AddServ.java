package antekai;


import java.io.IOException;
import java.io.PrintWriter;

import add.Ligand_DAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddServ")
public class AddServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		double ki=0;
	
		String ligname = request.getParameter("ligname");
		String smile = request.getParameter("smile");
		String recname = request.getParameter("recname");
		String unigene = request.getParameter("unigene");
		try{
			ki = Double.parseDouble(request.getParameter("ki")  ) ;
			 System.out.println("/n \n Ki="+ki);
		}
		finally{}
		
		
		Ligand ligand = new Ligand();
		ligand.setName(ligname);
		ligand.setSmile(smile);
		
		Receptor recp = new Receptor();
		recp.setName(recname);
		recp.setUnigene(unigene);
		
		
		int recID=0;
		int ligID=0;
		int x=0;
		int y=0;
		
		if(ligname!=null || smile!=null)
		{	
			try
			{	
				Ligand_DAO dao = new Ligand_DAO(ligand);
				ligID=dao.getDBID(ligand);
				System.out.println("*8888888888888  "+ligID);
				
				
		
			}
			
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x=1;
		}
		
		
		if(recname!=null || unigene!=null)
		{	
			try
			{	
				Receptor_DAO daoo = new Receptor_DAO(recp);
				recID = daoo.getDBID(recp);
				System.out.println("*******************    " + recID);
		
			}
			
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			y=1;
		}
		
		int z=x+y;
		if(z==2)
		{
			
			try {
				Ki_DAO da = new Ki_DAO(ki, ligID, recID);
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.append("Insertion was successful </br> </br>");
		
		out.append("<a href=\"FILE/add.jsp\"><strong>Add another one!</strong></a>");
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
