<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Mystery</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta
	content="A fully featured admin theme which can be used to build CRM, CMS, etc."
	name="description" />
<meta content="Coderthemes" name="author" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<!-- App favicon -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/assets/images/lugma_favicon.png">

<!--Morris Chart CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/morris/morris.css">

<!-- App css -->
<link
	href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/icons.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/style.css"
	rel="stylesheet" type="text/css" />

<script
	src="${pageContext.request.contextPath}/assets/js/modernizr.min.js"></script>

</head>



<body class="bg-accpunt-pages">

	<!-- HOME -->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">

					<div class="wrapper-page">

						<div class="account-pages">
							<div class="account-box">
								<div class="account-logo-box">
									<div style="float: left">
										<img
											src="${pageContext.request.contextPath}/images/DQI_icon.png"
											alt="" height="50">
									</div>
									<a href="index.html" class="text-success"> <span><img
											src="${pageContext.request.contextPath}/assets/images/DQI_icon.png"
											alt="" height="18"></span>
									</a>

								</div>

								<div class="account-content">
									<h6 class="text-uppercase text-center font-bold mt-4">Reset Password
										</h6>
									<form class="form-horizontal" action="${pageContext.request.contextPath}/resetPassword" method="Post"
										autocomplete="off">


										<div class="form-group m-b-20 row">
											<div class="col-12">
												<%-- <label for="emailaddress" style="color: red" class="message">${errMsg}</label> --%>
											</div>
											<div class="col-12">
												<label for="emailaddress">New Password</label> <input
													class="form-control" type="password" name="password" id="password"  required
													placeholder="Enter Your New Password" data-parsley-pattern= "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" data-parsley-pattern-message="Password Must contain at least one uppercase and one lowercase letter and one special character , and at least 8 or more characters" >
													 <input
													class="form-control" type="hidden" name="sk_user_id" id="sk_user_id"  required
													placeholder="Enter User Id" value="${userId}">
											</div>
										</div>
										
										
										<div class="form-group m-b-20 row">
											<div class="col-12">
												<%-- <label for="emailaddress" style="color: red" class="message">${errMsg}</label> --%>
											</div>
											<div class="col-12">
												<label for="emailaddress">Confirm Password</label> <input
													class="form-control" type="password" name="confirmPassword" id="confirmPassword" data-parsley-equalto="#password" required
													placeholder="Enter Confirm Password" >
											</div>
										</div>

										
										<div class="form-group row text-center m-t-10">
											<div class="col-12">
												<button
													class="btn btn-block btn-gradient waves-effect waves-light"
													type="submit">Submit</button>
											</div>
										</div>

									</form>

									<div class="row m-t-50">
										<div class="col-sm-12 text-center">
											<!--  <p class="text-muted">Don't have an account? <a href="page-register.html" class="text-dark m-l-5"><b>Sign Up</b></a></p> -->
										</div>
									</div>

								</div>
							</div>
						</div>
						<!-- end card-box-->


					</div>
					<!-- end wrapper -->

				</div>
			</div>
		</div>
	</section>
	<!-- END HOME -->



	<!-- jQuery  -->
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/waves.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.slimscroll.js"></script>

	<!--Morris Chart-->
	<script
		src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/pages/jquery.morris.init.js"></script>

	<!-- Chart JS -->
	<script
		src="${pageContext.request.contextPath}/plugins/chart.js/chart.bundle.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/pages/jquery.chartjs.init.js"></script>

	<!-- App js -->
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.core.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.app.js"></script>
	<!-- Parsley js -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/plugins/parsleyjs/parsley.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('form').parsley();
		});
	</script>


</body>