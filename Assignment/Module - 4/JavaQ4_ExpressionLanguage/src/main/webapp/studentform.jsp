<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Information Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 20px;
}

h2 {
	color: #333;
}

form {
	background-color: white;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	max-width: 400px;
	margin: auto;
}

label {
	font-weight: bold;
	display: block;
	margin-bottom: 5px;
}

input[type="text"], input[type="email"], input[type="tel"], input[type="password"],
	select {
	width: 100%;
	padding: 8px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

input[type="submit"] {
	background-color: #5cb85c;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
}

input[type="submit"]:hover {
	background-color: #4cae4c;
}
</style>
</head>
<body>

	<form action="StudentServlet" method="post">
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