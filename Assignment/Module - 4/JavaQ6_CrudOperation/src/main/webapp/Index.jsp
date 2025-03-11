<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Registration Form</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

<script type="text/javascript">
	function validateForm() {

		var name = document.getElementById("uname").value;
		var email = document.getElementById("email").value;
		var contact = document.getElementById("contact").value;
		var password = document.getElementById("password").value;
		var cpassword = document.getElementById("cpassword").value;

		var errName = document.getElementById("unameErr");
		var errEmail = document.getElementById("emailErr");
		var errContact = document.getElementById("contactErr");
		var errPassword = document.getElementById("passwordErr");
		var errCpassword = document.getElementById("cpasswordErr");

		var btnSubmit = document.getElementById("submit");

		// btnSubmit.disabled = false;

		// name validation 
		var regex = /^[A-Za-z]+$/;

		if (name == "") {
			errName.innerHTML = "Please enter first name";
			btnSubmit.disabled = true;
		} else if (!regex.test(name)) {
			errName.innerHTML = "Only alphabets are allowed";
			btnSubmit.disabled = true;
		} else {
			errName.innerHTML = "";
			btnSubmit.disabled = false;
		}

		// email validation 
		regex = /^[A-Za-z0-9._-]+@[A-Za-z.-]+\.[A-Za-z]{2,4}$/;

		if (email == "") {
			errEmail.innerHTML = "Please enter email address";
			btnSubmit.disabled = true;
		} else if (!regex.test(email)) {
			errEmail.innerHTML = "Invalid email address";
			btnSubmit.disabled = true;
		} else {
			errEmail.innerHTML = "";
			btnSubmit.disabled = false;
		}

		// contact validation
		regex = /^[0-9]{10}$/;

		if (contact == "") {
			errContact.innerHTML = "Please enter conact";
			btnSubmit.disabled = true;
		} else if (!regex.test(contact)) {
			errContact.innerHTML = "Invalid contact number";
			btnSubmit.disabled = true;
		} else {
			errContact.innerHTML = "";
			btnSubmit.disabled = false;
		}

		// validate password 
		regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@.#$!%*?&])[A-Za-z\d@.#$!%*?&]{8,15}$/;

		if (password == "") {
			errPassword.innerHTML = "Please enter password";
			btnSubmit.disabled = true;
		} else if (!regex.test(password)) {
			errPassword.innerHTML = "Must contains atleast one uppercase, lowercase, digit and length up to 16 characters";
			btnSubmit.disabled = true;
		} else {
			errPassword.innerHTML = "";
			btnSubmit.disabled = false;
		}

		if (cpassword != password || cpassword == "") {
			errCpassword.innerHTML = "Password mismatch";
			btnSubmit.disabled = true;
		} else {
			errCpassword.innerHTML = "";
			btnSubmit.disabled = false;
		}

	}
</script>

</head>
<body>

	<div class="container">

		<div class="row mt-4">

			<!-- Registration Form -->
			<div class="col-4 card p-2">

				<h3 class="text-center text-success">Registration Form</h3>
				<span class="text-center text-Danger">${msg }</span> <span
					class="text-center text-Danger">${error }</span>

				<form action="registration" method="post">

					<div class="form-group mt-3">
						<label class="form-label">User Name</label> <input type="text"
							class="form-control" id="uname" placeholder="Enter Name"
							name="uname" onkeyup="validateForm();"> <span
							id="unameErr" style="color: red;"></span>
					</div>

					<div class="form-group mt-3">
						<label class="form-label">Email Address</label> <input
							type="email" class="form-control" id="email"
							placeholder="Enter Email" name="email" onkeyup="validateForm();">
						<span id="emailErr" style="color: red;"></span>
					</div>

					<div class="form-group mt-3">
						<label class="form-label">Contact Number</label> <input
							type="text" class="form-control" id="contact"
							placeholder="Enter Contact Number" name="contact"
							onkeyup="validateForm();"> <span id="contactErr"
							style="color: red;"></span>
					</div>

					<div class="form-group mt-3">
						<label class="form-label">Password</label> <input type="password"
							class="form-control" id="password" placeholder="Enter Password"
							name="password" onkeyup="validateForm();"> <span
							id="passwordErr" style="color: red;"></span>
					</div>

					<div class="form-group mt-3">
						<label class="form-label">Confirm Password</label> <input
							type="password" class="form-control" id="cpassword"
							placeholder="Confirm Password" name="cpassword"
							onkeyup="validateForm();"> <span id="cpasswordErr"
							style="color: red;"></span>
					</div>


					<div class="d-flex justify-content-center mt-3">
						<input type="submit" class="btn btn-success" id="submit"
							name="submit" disabled> <input type="reset"
							class="btn btn-primary ms-2" id="reset" name="reset">
					</div>

				</form>

			</div>

			<div class="col-1"></div>

			<!-- Table Data -->
			<div class="col-7 card p-4">

				<h3 class="text-center text-success">User Details</h3>

				<table class="table table-striped table-hover mt-3">

					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Email</th>
						<th>Contact</th>
						<th colspan="2">Action</th>
					</tr>

					<%
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/WebApp", "root", "kiran@1727");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from Reg1");
					%>
					
						<%
						while (rs.next()) {
						%>
						<tr>
 						<td><%=rs.getInt("id") %></td>
 						<td><%=rs.getString("uname") %></td>
 						<td><%=rs.getString("email") %></td>
 						<td><%=rs.getString("contact") %></td>
 						<td><a href="edit?id=<%=rs.getInt("id") %>" class="btn btn-primary">Update</a></td>
 						<td><a href="delete?id=<%=rs.getInt("id")%>" class="btn btn-success">Delete</a></td>
 						
						<%
						}
						%>



					</tr>
				</table>

			</div>

		</div>

	</div>

</body>
</html>