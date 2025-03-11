<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<title>User List</title>
</head>
<body>
	<h2>Student List</h2>

	<sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/assignmentservlet" user="root"
		password="kiran@1727" />

	<sql:query var="result" dataSource="${dataSource}">  
    SELECT * FROM students;  
</sql:query>

	<table border="1">
		<tr>
			<th>ID</th>
			<th>Fname</th>
			<th>Lname</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Gender</th>
		</tr>

		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td>${row.id}</td>
				<td>${row.first_name}</td>
				<td>${row.last_name}</td>
				<td>${row.email}</td>
				<td>${row.mobile}</td>
				<td>${row.gender}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>