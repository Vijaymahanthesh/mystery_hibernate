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
<!-- App favicon -->
        <link rel="shortcut icon"
	href="${pageContext.request.contextPath}/design/images/DQI-icon.png">

<!--Morris Chart CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/morris/morris.css">



<link
	href="${pageContext.request.contextPath}/assets/css/jquery.growl.css"
	rel="stylesheet" type="text/css" />

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
                                        <h2 class="text-uppercase text-center">Mystery Shopping
                                         </h2>
                                        <h6 class="text-uppercase text-center font-bold mt-4">Sign In</h6>
                                    </div>

								<div class="account-content">
									<!-- <h6 class="text-uppercase text-center font-bold mt-4">Sign
										In</h6> -->
									<form class="form-horizontal" action="signin" method="Post"
										autocomplete="off">
                                          <div class="form-group m-b-20 row">
											<div class="col-12">
											</div>
											<div class="col-12">
												<label for="emailaddress">Email Address</label> <input
													class="form-control" type="email" name="email" id="email"  required
													placeholder="Enter Your Email">
											</div>
										</div>

										<div class="form-group row m-b-20">
											<div class="col-12">
												
														 <label for="password">Password</label> <input
													class="form-control" type="password" name="password"
													 required id="password"
													placeholder="Enter Your Password">
											</div>
										</div>
										<div class="form-group row text-center m-t-10">
											<div class="col-12">
												<button
													class="btn btn-block btn-gradient waves-effect waves-light"
													type="submit">Sign In</button>
											</div>
										</div>
										<div class="form-group row m-b-20">
                                                <div class="col-12">

                                                    <div class="checkbox checkbox-success">
                                                        <input id="remember" type="checkbox" >
                                                        <label for="remember">
                                                            Remember me
                                                        </label>
                                                        <a href="forgotPassword" class="text-muted pull-right"><small>Forgot
														Your Password?</small></a>
                                                    </div>

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
		src="${pageContext.request.contextPath}/assets/js/jquery.growl.js"></script>
		
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
	
	
	

	 
	 	<input type="hidden" id="validationstatus" value="${statusMessage}">
	<input type="hidden" id="statusCode" value="${statusCode}">
	<script>
		var validation_msg = $("#validationstatus").val();
		var statusCode = $("#statusCode").val();
		if (statusCode == "" || statusCode == null) {

		} 
		else if (statusCode == "0") {
			$.growl.error({
				message : "${statusMessage}"
			});

		}
		else {
			$.growl.notice({
				message : "${statusMessage}"
			});
		}
	</script> 
	<script>
        $(document).ready(function() {
       
          $(function() {

              if (localStorage.chkbx && localStorage.chkbx != '') {
                  $('#remember').attr('checked', 'checked');
                  $('#email').val(localStorage.usrname);
                  $('#password').val(localStorage.pass);
              } else {
                  $('#remember').removeAttr('checked');
                  $('#email').val('');
                  $('#password').val('');
              }

              $('#remember').click(function() {

                  if ($('#remember').is(':checked')) {
                      // save username and password
                      localStorage.usrname = $('#email').val();
                      localStorage.pass = $('#password').val();
                      localStorage.chkbx = $('#remember').val();
                  } else {
                      localStorage.usrname = '';
                      localStorage.pass = '';
                      localStorage.chkbx = '';
                  }
              });
          });
        });
</script>

</body>