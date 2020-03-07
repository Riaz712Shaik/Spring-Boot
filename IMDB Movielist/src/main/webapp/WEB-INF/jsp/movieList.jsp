<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="stag"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie List</title>
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
			<div style="margin-left: 20%;" align="center">
				<h2 style="margin-left: 200px;">
					<label>Add Movie</label>
				</h2>
			</div>
			<table style="vertical-align: center; margin-left: 20%;">
				<tr>
					<td>Movie Name :</td>
					<td><form:input path="movieName" id="mname" /></td>
				</tr>
				<tr>
					<td>year :</td>
					<td><form:input path="year" id="year" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Add" /></td>
				</tr>
			</table>
		</form:form>
	</div>

	<div style="margin-left: 20%;">
		<div
			style="width: 20%; float: left; margin-left: 200px; height: 50px;">
			<h2>
				<label>Movie List </label>
			</h2>
		</div>
		<div style="width: 60%; float: right; margin: 25px;">
			<form action="/search">
				<input type="text" placeholder="Search.." name="search"> <input
					type="submit" value="Search">
			</form>
		</div>
	</div>
	<table style="margin-top: 0px; margin-left: 20%;">
		<tr>
			<th>MovieName</th>
			<th>Year</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${movieList}" var="movie">
			<tr>
				<td>${movie.movieName}</td>
				<td>${movie.year}</td>
				<td><a href="/editMovie?id=${movie.id}">Edit</a> <a
					href="/delete?id=${movie.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>