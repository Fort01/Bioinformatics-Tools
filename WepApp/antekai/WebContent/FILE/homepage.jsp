<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />

	<style>

	              
   </style>
      		<link rel="stylesheet" type="text/css" href="css/NewFile.css"/>
      
    	     
	 <title>home_website</title>
	    </head>

        <body>	
			<p> <h1> Lig-<em>and</em>-base </h1> </p>
				    
		   <img src="images/li.png"  alt="ligand" align="center" >
		    
		 
		 
		 		    
		    <div id="right">	
		     <h3>
		      <ul id="side">
		        <li><a href="homepage.jsp"><strong>Home</strong></a></li>

	        	<li>
		        	<form method="get" action="../MyFirstServlet" > <input type="submit" value="All Ligands" align="middle" > </form>
	   	        </li> <!--****<a href="AllLigands.java" ><strong>All Ligands</strong></a>*********************************************-->
		        
		        <li>and  </li>
		        
		        <li>
		        	<form method="get" action="../AllReceptorsServlet"> <input type="submit" value="All Receptors" align="middle"> </form>		        	
		        </li>
		        
		        <li><a href="about.html"><strong>About</strong></a></li>
		     </ul>
		     </h3> 
		     
		     
		     
		     
		     
		     
		     	<table>     
					<form id="form2" method="get" action="../adminServlet">  	
				    	<tr>
				    		<td> 
				    			<input type="submit" value="log in">
				    		</td>
				    		<td>
				    			<input id="name" name="name" placeholder="name" type="text" maxlength="10" size="10" >
				    		</td>
				    	</tr>
					 
					 <tr>
					  	<td></td>
					  	
					 	<td>  
					 		<input id="code" name="code" placeholder="password" type="password" maxlength="10" size="10">
				 			</form>
				 		</td>
				 	</tr>
				</table>  
	     	
	     	</div>
  			
  			
  			
  			
  			
  			
  			<div class= "box red">
  			<h4>
  			
		  	<form id="form1" method="get" action="../Search">
			  <fieldset>
			  	   </br>
			 <table> 	   
			  <tr>
			<td>   <legend id="l1"><h3>Give name of receptor</h3></legend></td></tr>
			<tr>   <td >	<input id="name" name="receptor" type="text" maxlength="50" size="20"/> </td>	</tr>
			  
			 <tr><td>     <input id="submit" type="submit" value="search"></td></tr>	
				 
				</fieldset></h4>
		  	</table>
			  		 
		       </form>
   		     </div>
	  	 			
	  	 			
   </body>
</html>
