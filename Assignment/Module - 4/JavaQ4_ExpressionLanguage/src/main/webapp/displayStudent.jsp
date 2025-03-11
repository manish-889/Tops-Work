<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Information</title>
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

.student-info {
	background-color: white;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	max-width: 400px;
	margin: auto;
}

.info {
	margin-bottom: 10px;
}

.info label {
	font-weight: bold;
}
</style>
</head>
<body>

	<div class="student-info">
		<div class="info">
			<label>First Name:</label> <span>${firstName}</span>
		</div>
		<div class="info">
			<label>Last Name:</label> <span>${lastName}</span>
		</div>
		<div class="info">
			<label>Email:</label> <span>${email}</span>
		</div>
		<div class="info">
			<label>Mobile:</label> <span>${mobile}</span>
		</div>
		<div class="info">
			<label>Gender:</label> <span>${gender}</span>
		</div>
	</div>
</body>
</html>