<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<!-- Bootstrap container with top margin -->
		<div class="card">
			<div class="card-body">
				<h1 class="card-title text-center">Login</h1>
				<!-- Centered title -->
				<form action="login" method="post">
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" id="email" name="email" class="form-control"
							required>
					</div>
					<div class="mb-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" id="password" name="password"
							class="form-control" required>
					</div>
					<button type="submit" class="btn btn-primary w-100">Login</button>
					<!-- Full width button -->
				</form>
			</div>
		</div>
	</div>
</body>
</html>