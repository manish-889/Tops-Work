<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title  -->
<title>Amado - Furniture Ecommerce Template | Checkout</title>

<!-- Favicon  -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Style CSS -->
<link rel="stylesheet" href="css/core-style.css">
<link rel="stylesheet" href="style.css">

</head>

<body>
	<!-- Search Wrapper Area Start -->
	<div class="search-wrapper section-padding-100">
		<div class="search-close">
			<i class="fa fa-close" aria-hidden="true"></i>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="search-content">
						<form action="#" method="get">
							<input type="search" name="search" id="search"
								placeholder="Type your keyword...">
							<button type="submit">
								<img src="img/core-img/search.png" alt="">
							</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Search Wrapper Area End -->

	<!-- ##### Main Content Wrapper Start ##### -->
	<div class="main-content-wrapper d-flex clearfix">

		<!-- Mobile Nav (max width 767px)-->
		<div class="mobile-nav">
			<!-- Navbar Brand -->
			<div class="amado-navbar-brand">
				<a href="index.html"><img src="img/core-img/logo.png" alt=""></a>
			</div>
			<!-- Navbar Toggler -->
			<div class="amado-navbar-toggler">
				<span></span><span></span><span></span>
			</div>
		</div>

		<!-- Header Area Start -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- Header Area End -->

		<div class="cart-table-area section-padding-100">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12 col-lg-8">
						<div class="checkout_details_area mt-50 clearfix">

							<div class="cart-title">
								<h2>Checkout</h2>
							</div>

							<form action="#" method="post">
								<div class="row">

									<div class="col-md-12 mb-3">
										<h6>Username</h6>
										<input type="text" class="form-control" id="unsername"
											value="${userData.getUserName()}" required>
									</div>
									<div class="col-12 mb-3">
										<h6>Phone Number</h6>
										<input type="text" class="form-control" id="phoneNumber"
											value="${userData.getPhoneNumber()}">
									</div>
									<div class="col-12 mb-3">
										<h6>Email</h6>
										<input type="email" class="form-control" id="email"
											value="${userData.getEmail()}">
									</div>

									<div class="col-12 mb-3">
										<h6>Address</h6>
										<input type="text" class="form-control mb-3" id="address"
											value="${userData.getAddress()}">
									</div>
									<div class="col-12 mb-3">
										<h6>Pincode</h6>
										<input type="text" class="form-control" id="pincode"
											value="${userData.getPincode()}">
									</div>


								</div>
							</form>
						</div>
					</div>
					<div class="col-12 col-lg-4">
						<div class="cart-summary">
							<h5>Cart Total</h5>
							<c:set value="0" var="total" />
							<c:forEach items="${cart}" var="d">
								<c:set var="total"
									value="${total + d.getProduct().getPrice() * d.getProductQuantity()}" />
							</c:forEach>

							<ul class="summary-table">
								<li><span>subtotal:</span> <span>${total}</span></li>
								<li><span>delivery:</span> <span>₹ 40</span></li>
								<li><span>total:</span> <span>₹ <span id="amt">${total + 40}</span>
								</span></li>
							</ul>

							<div class="payment-method">
								<!-- Cash on delivery -->
								<div class="custom-control custom-checkbox mr-sm-2">
									<input type="radio" name="pay" class="custom-control-input"
										id="cod" checked> <label class="custom-control-label"
										for="cod">Cash on Delivery</label>
								</div>
								<!-- Paypal -->
								<div class="custom-control custom-checkbox mr-sm-2">
									<input type="radio" name="pay" class="custom-control-input"
										id="paypal"> <label class="custom-control-label"
										for="paypal">Razor Pay <img class="ml-15"
										src="img/core-img/paypal.png" alt="">
									</label>
								</div>
							</div>

							<div class="cart-btn mt-100">
								<button id="btnPay" class="btn amado-btn w-100">Checkout</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ##### Main Content Wrapper End ##### -->



	<!-- ##### Footer Area Start ##### -->
	<footer class="footer_area clearfix">
		<div class="container">
			<div class="row align-items-center">
				<!-- Single Widget Area -->
				<div class="col-12 col-lg-4">
					<div class="single_widget_area">
						<!-- Logo -->
						<div class="footer-logo mr-50">
							<a href="index.html"><img src="./Img/VibeCart2.png" alt=""></a>
						</div>
						<!-- Copywrite Text -->
						<p class="copywrite">
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | This template is made with <i
								class="fa fa-heart-o" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a> &
							Re-distributed by <a href="https://themewagon.com/"
								target="_blank">Themewagon</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>
				</div>
				<!-- Single Widget Area -->
				<div class="col-12 col-lg-8">
					<div class="single_widget_area">
						<!-- Footer Menu -->
						<div class="footer_menu">
							<nav class="navbar navbar-expand-lg justify-content-end">
								<button class="navbar-toggler" type="button"
									data-toggle="collapse" data-target="#footerNavContent"
									aria-controls="footerNavContent" aria-expanded="false"
									aria-label="Toggle navigation">
									<i class="fa fa-bars"></i>
								</button>
								<div class="collapse navbar-collapse" id="footerNavContent">
									<ul class="navbar-nav ml-auto">
										<li class="nav-item active"><a class="nav-link" href="/">Home</a></li>
										<li class="nav-item"><a class="nav-link" href="shop">Shop</a>
										</li>

										<li class="nav-item"><a class="nav-link" href="cart">Cart</a>
										</li>
										<li class="nav-item"><a class="nav-link" href="checkout">Checkout</a></li>
									</ul>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- ##### Footer Area End ##### -->

	<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
	<script>
		document.getElementById('btnPay').onclick = function(e) {

			e.preventDefault();
			var amt = $("#amt").text().trim();
			
			 var username = $("#unsername").val().trim(); 
		     var email = $("#email").val().trim();  
		     var contact = $("#phoneNumber").val().trim(); 
			
			$.get("payment", {amt}, function(rs) {
				
				var data = JSON.parse(rs)

				var options = {
					"key" : "rzp_test_OHjwiuWFUgliRX", // Enter the Key ID generated from the Dashboard
					"amount" : data.amount, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
					"currency" : "INR",
					"name" : "Manish Giri",
					"description" : "VibeCart",
					"image" : "https://example.com/your_logo",
					"order_id" : data.id, //This is a sample Order ID. Pass the id obtained in the response of Step 1
					"handler" : function(response) {
						
						var oId = response.razorpay_order_id;
						
						$.get("addOrder",{oId},function(resp){
							
						})
					},
					"prefill" : {
						"name" : username,
						"email" : email,
						"contact" : contact
					},
					"notes" : {
						"address" : "Razorpay Corporate Office"
					},
					"theme" : {
						"color" : "#3399cc"
					}
				};
				var rzp1 = new Razorpay(options);
				rzp1.on('payment.failed', function(response) {
					alert(response.error.code);
					alert(response.error.description);
					alert(response.error.source);
					alert(response.error.step);
					alert(response.error.reason);
					alert(response.error.metadata.order_id);
					alert(response.error.metadata.payment_id);
				});
				rzp1.open();
			})

			
		}
	</script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>
	


	<!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
	<script src="js/jquery/jquery-2.2.4.min.js"></script>
	<!-- Popper js -->
	<script src="js/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Plugins js -->
	<script src="js/plugins.js"></script>
	<!-- Active js -->
	<script src="js/active.js"></script>

</body>

</html>