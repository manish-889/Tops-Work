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
<title>Amado - Furniture Ecommerce Template | Cart</title>

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
						<div class="cart-title mt-50">
							<h2>Shopping Cart</h2>
						</div>

						<div class="cart-table clearfix">
							<table class="table table-responsive">
								<thead>
									<tr>
										<th></th>
										<th>Name</th>
										<th>Price</th>
										<th>Quantity</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${cart}" var="dt">
										<tr>
											<td class="cart_product_img"><a href="#"><img
													src="./Img/${dt.getProduct().getImageName()}" alt="Product"></a>
													<div>
												<a href="remove?cid=${dt.getCartId()} "
												class="btn btn-danger mt-2 d-flex justify-content-center">Remove</a>
												</div>
											</td>
											<td class="cart_product_desc">
												<h5>${dt.getProduct().getProductName()}</h5>
											</td>
											<td class="price"><span>${dt.getProduct().getPrice()}</span>
											</td>
											<td class="qty">
												<span>${dt.getProductQuantity()}</span>
												<%-- <div class="qty-btn d-flex">
													<p>Qty</p>
													<div class="quantity">
														<span class="qty-minus"
															onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i
															class="fa fa-minus" aria-hidden="true"></i></span> <input
															type="number" class="qty-text" id="qty" step="1" min="1"
															max="300" name="quantity"
															value="${dt.getProductQuantity()}"> <span
															class="qty-plus"
															onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i
															class="fa fa-plus" aria-hidden="true"></i></span>
													</div> 
												</div>--%> 
												

											</td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
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
								<li><span>total:</span> <span>₹ ${total + 40} </span></li>
							</ul>
							<div class="cart-btn mt-100">
								<a href="checkout" class="btn amado-btn w-100">Checkout</a>
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
							All rights reserved | This Project is made with <i
								class="fa fa-heart-o" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Manish Giri</a>
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
										<li class="nav-item active"><a class="nav-link"
											href="/">Home</a></li>
										<li class="nav-item"><a class="nav-link" href="shop">Shop</a>
										</li>
										
										<li class="nav-item"><a class="nav-link" href="cart">Cart</a>
										</li>
										<li class="nav-item"><a class="nav-link"
											href="checkout">Checkout</a></li>
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