<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Edit Profile</title>
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
</style>
</head>
<body>
	<div class="container profile-card">
		<!-- Container for the card and top margin -->
		<div class="card">
			<div class="card-body">
				<h1 class="card-title text-center">Edit Profile</h1>
				<!-- Centered title -->
				<form action="update" method="post" enctype="multipart/form-data">
					<div class="mb-3">
						<label for="name" class="form-label">Name</label> <input
							type="text" id="name" name="name" class="form-control"
							value="${student.name}" required>
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" id="email" name="email" class="form-control"
							value="${student.email}" required>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" id="password" name="password"
							class="form-control" value="${student.password}" required>
					</div>
					<div class="mb-3">
						<label for="photo" class="form-label">Profile Photo</label> <input
							type="file" id="photo" name="photo" class="form-control">
					</div>
					<button type="submit" class="btn btn-primary w-100">Update</button>
					<!-- Full width button -->
				</form>
			</div>
		</div>
	</div>
</body>
</html>