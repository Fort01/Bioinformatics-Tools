<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />

	<style>

	              
   </style>
		<link rel="stylesheet" type="text/css" href="css/NewFile.css"/>
    	     
	 <title>member's_home_website</title>
	    </head>

        <body>	
			<p> <h1> Lig-<em>and</em>-base </h1> </p>
				    
		   <img src="images/li.png"  alt="ligand" align="center" >
		    
		    
			
			
			
			
			
		    <div id="right">
	   	 	 <aside id="sidebar">
		     <h3>
		      <ul>
		        <li><a href="homepage.jsp"><strong>Home</strong></a></li>		        
		        	<form method="get" action="../MyFirstServlet"> <input type="submit" value="All Ligands"> </form>
		        <li>
		        	
		        </li> <!--****<a href="AllLigands.java" ><strong>All Ligands</strong></a>*********************************************-->
		        <li>
		        	<form method="get" action="../AllReceptors"> <input type="submit" value="All Receptors"> </form>		        	
		        <li><a href="about.html"><strong>About</strong></a></li>
		     </ul>
		     </h3> 
	     	</aside>
	     	</div>
  					
  					
  					
  					
  					
  					
  					
  					
  					
  					
  					
  					
  					
  					
  			<div class= "box red">
  			<h4>
		  	<form id="add" method="get" action="../AddServ">
			 	 <fieldset>
			  	   </br>	
			  	   	  	   
					  <legend id="l1"><h3>Add Ligands</h3></legend>
					  <table id="first box">
			     <tr>
					  <td align="left"><label for="lig"> Ligand name: </label></td>
					  <td align="right"><input id="lig" name="ligname" type="text" maxlength="200" size="30"/></td>
				 </tr>				 
				 </br>				 
				 <tr>	
					 <td align="left"> <label for="smile"> Ligands smile:  </label> </td>
					 <td align="right">	<input id="smile" name="smile" type="text" maxlength="200" size="30"/></td>
				</tr>
				</table>					
				</fieldset>
				
				<fieldset>
				   </br>
					  <legend id="l1"><h3>Add Receptors</h3></legend>
					  <table id="second box">
			     <tr>
					  <td align="left"> 	<label for="rec"> Receptor name:  </label></td>
					  <td align="right">	<input id="rec" name="recname" type="text" maxlength="50" size="20"/> </td>
				 </tr> 
				   </br>
				 <tr>
					 <td align="left">	<label for="unigene"> Unigene:  </label></td> 
					 <td align="right">	<input id="unigene" name="unigene" type="text" maxlength="50" size="20"/> </td>	
				 </tr> 
				 </table>
				</fieldset>
				
				<fieldset>
				    </br>
				<legend id="l1"><h3> Ki between this receptor and this ligand</h3>  </legend>
				<table id="third box">
				<tr>
					   <td align="left"> <label for="Ki"> Give  Ki: </label> </td> 
					   <td align="right"><input id="Ki" name="ki" type="text" maxlength="5" size="10">[nM]</td>
				   </br>
				</tr>
				</fieldset>
				</h4>
		  		</table>
		  		
			 			<input id="submit" type="submit" value="submit">			 
		    </form>
   		    </div>
   	         
   	         
   	         
   	         
   	                
	  	 			
   </body>
</html>
