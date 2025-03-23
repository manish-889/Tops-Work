<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link rel="shortcut icon" href="./files/images/favicon-32x32.png" type="image/x-icon">
 <%@ include file="headerfile.jsp" %>

</head>

<body>





<c:forEach items="${CompanyKey}" var="p">
<form action="updateprofilec" method="post" enctype="multipart/form-data">
<div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="./files/webimages/${p.profilec }"><span class="font-weight-bold">${p.name }</span><span class="text-black-50">${p.email }</span><br><span><label>Update Profile Pic</label><br><input name="filename" type="file" /> </span></div>
        </div>
        
        <div class="col-md-5 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Company Profile</h4>
                </div>
                
                
                <div class="row mt-2">
                    <div class="col-md-12"><label class="labels">Name of Company</label><input type="text" class="form-control" placeholder="Company Name" name="name" value="${p.name }"></div>
                    
                </div>
                
                <input type="hidden" class="form-control" placeholder="first name" name="id" value="${p.id}">
                <div class="row mt-3">
                    <div class="col-md-6"><label class="labels">Mobile Number</label><input type="text" class="form-control" placeholder="Number of Company" name="number" value="${p.number }"></div>
                    <div class="col-md-6"><label class="labels">Email Address</label><input type="text" class="form-control" placeholder="Email of Company" name="email"  value="${p.email }"></div>
                   <div class="col-md-12"><label class="labels">Website</label><input type="text" class="form-control" placeholder="Website of Company" name="website" value="${p.website }"></div>
                    <div class="col-md-12"><label class="labels">About us</label> <input type="text"  class="form-control"   placeholder="About Company" name="about" value="${p.about }"  style="height:100px;"></div>
              
                <div class="mt-5 text-center"><button class="btn btn-primary profile-button" type="submit">Save Profile</button></div>
                &nbsp;
                <div class="mt-5 text-center"><a href="homec"><button class="btn btn-primary profile-button" type="button"><i class="fa-solid fa-house"></i> &nbsp;Home</button></a></div>
            </div>
        </div>
       
    </div>
</div>
</div>
</form>
</c:forEach>

<!-- Footer section Start -->
  
   <%@ include file="footerfile.jsp" %>

  <!-- Footer Section end -->



<style>
body {
    background: rgb(99, 39, 120)
}

.form-control:focus {
    box-shadow: none;
    border-color: #BA68C8
}

.profile-button {
    background: rgb(99, 39, 120);
    box-shadow: none;
    border: none
}

.profile-button:hover {
    background: #682773
}

.profile-button:focus {
    background: #682773;
    box-shadow: none
}

.profile-button:active {
    background: #682773;
    box-shadow: none
}

.back:hover {
    color: #682773;
    cursor: pointer
}

.labels {
    font-size: 11px
}

.add-experience:hover {
    background: #BA68C8;
    color: #fff;
    cursor: pointer;
    border: solid 1px #BA68C8
}</style>


 
</body>
</html>