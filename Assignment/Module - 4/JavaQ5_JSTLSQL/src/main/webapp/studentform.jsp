<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Information Form</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #e9ecef;
	margin: 0;
	padding: 20px;
}

h2 {
	color: #495057;
	text-align: center;
	margin-bottom: 20px; /* Added spacing below heading */
}

form {
	background-color: #ffffff;
	padding: 30px;
	border-radius: 12px; /* Rounded corners */
	box-shadow: 0 8px 24px rgba(0, 0, 0, 0.2);
	/* Deeper shadow for card effect */
	max-width: 450px;
	margin: auto;
	transition: transform 0.2s; /* Smooth transition for hover effect */
}

form:hover {
	transform: translateY(-2px); /* Lift effect on hover */
}

label {
	font-weight: bold;
	display: block;
	margin-bottom: 6px;
	color: #343a40;
}

input[type="text"], input[type="email"], input[type="tel"], input[type="password"],
	select {
	width: 100%;
	padding: 12px;
	margin-bottom: 20px;
	border: 2px solid #ced4da;
	border-radius: 8px; /* Rounded input fields */
	transition: border-color 0.3s;
}

input[type="text"]:focus, input[type="email"]:focus, input[type="tel"]:focus,
	input[type="password"]:focus, select:focus {
	border-color: #80bdff;
	outline: none;
}

input[type="submit"] {
	background-color: #007bff;
	color: white;
	padding: 12px;
	border: none;
	border-radius: 8px; /* Rounded button */
	cursor: pointer;
	font-size: 16px;
	transition: background-color 0.3s;
	width: 100%;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>

	<form action="Student" method="post">
		<label for="fname">First Name:</label> <input type="text" id="fname"
			name="fname" required> <label for="lname">Last Name:</label>
		<input type="text" id="lname" name="lname" required> <label
			for="email">Email:</label> <input type="email" id="email"
			name="email" required> <label for="mobile">Mobile:</label> <input
			type="tel" id="mobile" name="mobile" required> <label
			for="gender">Gender:</label> <select id="gender" name="gender"
			required>
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			<option value="Other">Other</option>
		</select> <label for="password">Password:</label> <input type="password"
			id="password" name="password" required> <input type="submit"
			value="Submit">
	</form>
</body>
</html>