<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>

 body { background-image: url("C:/Users/Faih/workspace/Exaskhsh/WebContent/images/forma.jpg");}


</style>

<title>sign_up</title>
</head>

<body>

<p> <h2> Registration form </h2> </p>


<form id="sign_up" method="get" action="pare_ta_stoixeia_toy_melous.jsp">
_
			  <fieldset>
			  	   </br>
			  	   
			  	<table id="box">
			     <tr>
				  <td align="left"><label for="Last_name"> Last name </label></td>
				  <td align="right"><input id="last_name" name="Last_name"  placeholder="Last name" type="text" maxlength="200" size="30"/></td>
				 </tr>	
				 
				 </br>
				 
				 <tr>	
				 <td align="left"> <label for="name"> Name </label> </td>
				 <td align="right">	<input id="name" name="name" placeholder="Name" type="text" maxlength="200" size="30"/></td>
				</tr>
				
				</table>
				
				<tr>
				<td align="left"> <label for="job"> Job / work  </label> </td>
				
				<tb>
	                <select name="lista" id="lista">
					<option value="student">Student</option>
					<option value="professor"> Professor </option>
					<option value="researcher"> Researcher </option>
					</select>
					</fieldset>
				</tb></tr>
							
				<fieldset>
				   </br>
				  
				  <table id="box2">
			     <tr>
				  <td align="left"> <label for="email"> E-mail  </label></td>
				  <td align="right">	<input id="email" name="email" placeholder="e-mail" type="text" maxlength="50" size="20"/> </td>
				 </tr> 
				   </br>
				 <tr>
				 <td align="left">	<label for="password"> Password  </label></td>
				 <td align="right">	<input id="pass" name="pass"placeholder="password" type="text" maxlength="50" size="20"/> </td>	
				 </tr> 
				 <tr>
				 <td align="left"> <label for="2password"> Confirm password </label> </td>
				 <td align="right"> <input id="2pass" name="2pass" placeholder="confirm password" type="text" maxlength="50" size="20"> </td>
				 </table>
				</fieldset>
				 <input id="submit" type="submit" value="submit">
				 </form>

</body>
</html>

