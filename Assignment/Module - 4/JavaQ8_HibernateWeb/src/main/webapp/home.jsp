<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	background-color: #f8f9fa; /* Light background for contrast */
}

.profile-card {
	margin-top: 50px; /* Space at the top */
}

.profile-card img {
	border-radius: 50%; /* Circular profile picture */
}
</style>
</head>
<body>
	<div class="container profile-card">
		<div class="card">
			<div class="card-body text-center">
				<!-- Centered text within the card -->
				<h1>Welcome, ${student.name}</h1>
				<img src="uploads/${student.photo}" alt="Profile Picture"
					class="img-thumbnail" style="max-width: 150px;">
				<p>Email: ${student.email}</p>
				<a href="edit.jsp" class="btn btn-secondary">Edit Profile</a> <a
					href="logout" class="btn btn-danger">Logout</a>
			</div>
		</div>
	</div>
</body>
</html>