<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring 3 MVC Multipe Row Submit - viralpatel.net</title>
</head>
<body>

<h2>Spring MVC Multiple Row Form Submit example</h2>
<form method="post" action="save" id="contactForm">
	<table>
	<tr>
		<th>No.</th>
		<th>Name</th>
		<th>Lastname</th>
		<th>Email</th>
		<th>Phone</th>
	</tr>
	
		<tr>
			<td><input name="contacts[0].firstname"    value="Michele"/></td>
			<td><input name="contacts[0].lastname" value="Pantaleone"/></td>
			<td><input name="contacts[0].email"     value=""/></td>
			<td><input name="contacts[0].phone"     value="324"/></td>
		</tr>
<!-- 		<tr> -->
<!-- 			<td><input name="contacts[1].firstname" value="Nicola"/></td> -->
<!-- 			<td><input name="contacts[1].lastname" value="stilla"/></td> -->
<!-- 			<td><input name="contacts[1].email" value=""/></td> -->
<!-- 			<td><input name="contacts[1].phone" value="34333"/></td> -->
<!-- 		</tr> -->
</table>	
<br/>
<input type="submit" value="Save" />
	
</form>
</body>
</html>