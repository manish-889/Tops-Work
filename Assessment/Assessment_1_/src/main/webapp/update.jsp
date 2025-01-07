<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@page isELIgnored="false"%>
<!DOCTYPE html>  
<html lang="en">  
<head>  
    <meta charset="UTF-8">  
    <title>Update Employee</title>  
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">  
    <link rel="stylesheet" href="css/styles.css">  
</head>  
<body>  
    <div class="container mt-5">  
        <h2 class="text-center">Update Employee</h2>  
        <div class="card">  
            <div class="card-body">  
                <form method="post" action="UpdateEmplaoyee">    
 
 					<input type="hidden" name="id" value="${emp.getId() }" />
			
                    <div class="form-group">  
                        <label>First Name</label>  
                        <input type="text" class="form-control" value="${emp.getFname() }" name="fname" required>  
                    </div>  

                    <div class="form-group">  
                        <label>Last Name</label>  
                        <input type="text" class="form-control" value="${emp.getLname() }" name="lname" required>  
                    </div>  

                    <div class="form-group">  
                        <label>Email</label>  
                        <input type="email" class="form-control" value="${emp.getEmail() }" name="email" required>  
                    </div>  

                    <div class="form-group">  
                        <label>Mobile</label>  
                        <input type="tel" class="form-control" value="${emp.getMob() }" name="mob" required>  
                    </div> 
  
                    <button type="submit" class="btn btn-primary">Update</button>  
                </form>  
                
            </div>  
        </div>  
    </div>  
</body>  
</html>