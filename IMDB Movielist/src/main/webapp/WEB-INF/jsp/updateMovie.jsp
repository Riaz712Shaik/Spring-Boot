<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Movie</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 60%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: center;
	padding: 8px;
}

a {
	text-decoration: none;
}
</style>
</head>
<body style="background-color: #FFFFE0;">
	<div>
		<form:form method="POST" modelAttribute="movie" action="/addMovie"
			name="movie">
			<div style="margin-left: 30%;">
				<h2 style="margin-left: 200px;">
					<label>Update Movie</label>
				</h2>
			</div>
			<table style="vertical-align: center; margin-left: 20%;">
				<tbody>
					<tr>
						<td>Movie Name :</td>
						<td><form:input path="movieName" /></td>
					</tr>
					<tr>
						<td>year :</td>
						<td><form:input path="year" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Update" /></td>
					</tr>
				</tbody>
			</table>
			<form:hidden path="id" />
		</form:form>
	</div>
</body>
</html>