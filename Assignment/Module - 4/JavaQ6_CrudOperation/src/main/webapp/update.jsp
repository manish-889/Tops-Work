<%@page import="java.util.HashMap"%>
<%@page import="jakarta.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<div class="row mt-4">

			<!-- Registration Form -->
			<div class="col-4 card p-2">

				<h3 class="text-center text-success">Update Form</h3>
				<span class="text-center text-Danger">${msg }</span> <span
					class="text-center text-Danger">${error }</span>
					<%
					
					 HashMap<String,Object> data=(HashMap<String,Object>)request.getAttribute("data");
					%>

				<form action="update" method="post">

					<div class="form-group mt-3">
					<input type="hidden" value="<%=data.get("id") %>" name="id" >
						<label class="form-label">User Name</label> <input type="text"
							class="form-control" id="uname" value="<%=data.get("name")%>" placeholder="Enter Name"
							name="uname" onkeyup="validateForm();"> <span
							id="unameErr" style="color: red;"></span>
					</div>

					<div class="form-group mt-3">
						<label class="form-label">Email Address</label> <input
							type="email" class="form-control" id="email" value="<%=data.get("email") %>"
							placeholder="Enter Email" name="email"  onkeyup="validateForm();">
						<span id="emailErr" style="color: red;"></span>
					</div>

					<div class="form-group mt-3">
						<label class="form-label">Contact Number</label> <input
							type="text" class="form-control" id="contact" value="<%=data.get("contact") %>"
							placeholder="Enter Contact Number" name="contact"
							onkeyup="validateForm();"> <span id="contactErr"
							style="color: red;"></span>
					</div>

					<div class="form-group mt-3">
						<label class="form-label">Password</label> <input type="password"value="<%=data.get("password") %>"
							class="form-control" id="password" placeholder="Enter Password"
							name="password" onkeyup="validateForm();"> <span
							id="passwordErr" style="color: red;"></span>
					</div>



					<div class="d-flex justify-content-center mt-3">
						<input type="submit" class="btn btn-success" id="submit"
							name="submit" > 
					</div>

				</form>

			</div>
	
</body>
</html>