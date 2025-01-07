<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html>  
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <title>Add Employee</title>  
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">  
    <link rel="stylesheet" href="css/styles.css">  
</head>  
<body>  
    <div class="container mt-5">  
        <h2 class="text-center">Add Employee</h2>  
        <div class="card">  
            <div class="card-body">  
                <form method="post" action="AddEmployee">    
 
					
					<span class="text-center text-primary">${msg}</span>
					<span class="text-center text-primary">${deleteMsg}</span>
					
					

                    <div class="form-group">  
                        <label>First Name</label>  
                        <input type="text" class="form-control" name="fname" required>  
                    </div>  

                    <div class="form-group">  
                        <label>Last Name</label>  
                        <input type="text" class="form-control" name="lname" required>  
                    </div>  

                    <div class="form-group">  
                        <label>Email</label>  
                        <input type="email" class="form-control" name="email" required>  
                    </div>  

                    <div class="form-group">  
                        <label>Mobile</label>  
                        <input type="tel" class="form-control" name="mob" required>  
                    </div>  
 
                    <div class="form-group">  
                        <label>Address</label>  
                        <textarea class="form-control" name="address" rows="3" required></textarea>  
                    </div>  
 
                    <div class="form-group">  
                        <label>Gender</label><br>  
                        <div class="form-check form-check-inline">  
                            <input class="form-check-input" type="radio" name="gender" value="Male" required>  
                            <label class="form-check-label">Male</label>  
                        </div>  
                        <div class="form-check form-check-inline">  
                            <input class="form-check-input" type="radio" name="gender" value="Female" required>  
                            <label class="form-check-label">Female</label>  
                        </div>  
                    </div>  

                    <div class="form-group">  
                        <label>Password</label>  
                        <input type="password" class="form-control" name="password" required>  
                    </div>  
 
                    <div class="form-group">  
                        <label>Confirm Password</label>  
                        <input type="password" class="form-control" name="cpassword" required>  
                    </div>  

  
                    <button type="submit" class="btn btn-success">Submit</button>  
                    <a href="index.jsp" class="btn btn-outline-secondary">Back</a>  
                </form>  
                
            </div>  
        </div>  
    </div>  
</body>  
</html>