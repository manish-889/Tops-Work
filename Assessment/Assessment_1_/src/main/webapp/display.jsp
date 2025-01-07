<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>View Employees</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">List of Employees</h2>
		<span class="text-center text-primary">${updatemsg}</span>
		<table class="table table-hover table-dark mt-2">
			<thead class="">
				<tr>
					<th>EMPID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Mobile</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="l">
					<tr>
						<td>${l.getId() }</td>
						<td>${l.getFname() }</td>
						<td>${l.getLname() }</td>
						<td>${l.getEmail() }</td>
						<td>${l.getMob() }</td>
						<td><a href="edit?uid=${l.getId()}&action=update" class="btn btn-primary">Update</a></td>
						<td><a href="edit?uid=${l.getId()}&action=delete" class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center">
			<a href="index.jsp" class="btn btn-outline-primary">Back</a>
		</div>
	</div>
</body>
</html>