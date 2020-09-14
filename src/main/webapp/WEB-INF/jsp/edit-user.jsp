<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8" />
<title>Mystery-Users</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta
	content="A fully featured admin theme which can be used to build CRM, CMS, etc."
	name="description" />
<meta content="Coderthemes" name="author" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<!-- App favicon -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/design/images/DQI-icon.png">

<link href="${pageContext.request.contextPath}/plugins/select2/css/select2.min.css"
	rel="stylesheet" type="text/css" />
	
<!-- DataTables -->
<link
	href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/plugins/datatables/buttons.bootstrap4.min.css"
	rel="stylesheet" type="text/css" />
<!-- Responsive datatable examples -->
<link
	href="${pageContext.request.contextPath}/plugins/datatables/responsive.bootstrap4.min.css"
	rel="stylesheet" type="text/css" />

<!-- Custom box css -->
<link href="${pageContext.request.contextPath}/plugins/custombox/css/custombox.min.css"
	rel="stylesheet">

<!-- App css -->
<link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/icons.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/metismenu.min.css" rel="stylesheet"
	type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet"
	type="text/css" />
<%-- 	 <link href="${pageContext.request.contextPath}/assets/css/nice-select.css" rel="stylesheet" type="text/css" />
 --%>	
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.33.1/sweetalert2.min.css" />
	
<script src="${pageContext.request.contextPath}/assets/js/modernizr.min.js"></script>
<style>
#userType {
	position: relative;
	left: 20px;
}

#icon {
	position: relative;
	top: 31px;
	font-size: 20px;
}
</style>

</head>

<body>
	<div id="wrapper">
		<!-- Navigation Bar-->
		<jsp:include page="include/header.jsp"></jsp:include>
		<jsp:include page="include/sidemenu.jsp"></jsp:include>
		<!-- End Navigation Bar-->

		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="container-fluid">

					<div class="row">
						<div class="col-sm-12">
							<div class="page-title-box">
								<div class="btn-group pull-right">
									<ol class="breadcrumb hide-phone p-0 m-0">
										<li class="breadcrumb-item"><a href="#">MYS</a></li>
										<li class="breadcrumb-item"><a href="#">Users</a></li>
									</ol>
								</div>
								<h4 class="page-title">Create User</h4>
							</div>
						</div>
					</div>

					<div class="row">

						<div class="col-lg-12">

							<div class="card-box ">
								<h4 class="header-title m-t-0"></h4>
								<form method="POST" action="${pageContext.request.contextPath}/createUser" id="user" autocomplete="off">
									<div class="row">
										<div class="form-group col-md-6">
											<label for="Address">First Name<span
												class="text-danger">*</span></label> <input type="text" 
												class="form-control" id="first_name" name="first_name"
												data-parsley-pattern="/^[a-zA-Z ]*$/"
												placeholder="Enter First Name" value="${userDetails.first_name}" required data-parsley-maxlength="100">
												<input type="hidden" 
												class="form-control" id="sk_user_id" name="sk_user_id" value="${userDetails.sk_user_id}"
												placeholder="Enter First Name" >
										</div>
										<div class="form-group col-md-6">
											<label for="Address">Last Name<span
												class="text-danger">*</span></label> <input type="text" 
												 value="${userDetails.last_name}" class="form-control" id="last_name" name="last_name"
												data-parsley-pattern="/^[a-zA-Z ]*$/"
												placeholder="Enter Last Name" required data-parsley-maxlength="100">
										</div>
										<div class="form-group col-md-6">
											<label for="Address">Email<span class="text-danger">*</span></label>
											<input type="email"  class="form-control" id="email"
												name="email" value="${userDetails.email}" onkeyup="checkMailExist(this.value)"
												placeholder="Enter Email" required> 
												 <span id="emailExistErrorMsg" style="color:red"></span>
                                       
										</div>
										<div class="form-group col-md-6">
											<label for="Address">Password<span
												class="text-danger">*</span></label> <input type="password" required
												class="form-control" id="password" name="password" 
												placeholder="Enter Password" value="${userDetails.password}"  data-parsley-pattern= "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$" data-parsley-pattern-message="Password Must contain at least one uppercase and one lowercase letter and one special character , and at least 8 or more characters">
										</div>
										<div class="form-group col-md-6">
											<label for="Address">Mobile<span class="text-danger">*</span></label>
											<input type="text" required class="form-control" id="mobile"
												name="mobile_number"
												data-parsley-length-message="Please Enter Valid Mobile Number"
												data-parsley-length="[10, 10]" value="${userDetails.mobile_number}"  data-parsley-type="integer"
												placeholder="Enter Mobile" >
										</div>
										<%-- <div class="form-group col-md-6">
											<label for="pass1">Role<span class="text-danger">*</span></label>
											<select id="sk_role_id" name="sk_role_id" required
												class="form-control">
												<option value="">Select role</option>
												 <c:forEach var="uBean" items="${roleList}">
													<option value="${uBean.sk_role_id}">${uBean.role_name}</option>
												</c:forEach> 
												
											</select>
										</div> --%>
									</div>

									<div class="form-group text-right m-b-0">
										<button class="btn btn-gradient waves-effect waves-light"
											id="button-submit" type="submit">Upadte</button>
										<a href="${pageContext.request.contextPath}/viewUser"><button type="submit" id="reset"
											class="btn btn-light waves-effect m-l-5">cancel</button></a>

									</div>

								</form>
							</div>
							<!-- end card-box -->
						</div>
					</div>
					<!-- end row -->
				</div>
			</div>
		</div>
		<!-- end container -->
	</div>
<!-- end wrapper -->


	<!-- Footer -->
	<jsp:include page="include/footer.jsp"></jsp:include>
	<!-- End Footer -->


	<!--  jQuery  -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/metisMenu.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/waves.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.slimscroll.js"></script>
	<!-- Modal-Effect -->
	<script src="${pageContext.request.contextPath}/plugins/custombox/js/custombox.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/custombox/js/legacy.min.js"></script>

	<!-- plugin Js -->
	<script src="${pageContext.request.contextPath}/plugins/switchery/switchery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-tagsinput/js/bootstrap-tagsinput.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/select2/js/select2.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-select/js/bootstrap-select.js"
		type="text/javascript"></script>
	<!--  Required datatable js -->
	<script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap4.min.js"></script>
	<!-- Buttons examples -->
	<script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.buttons.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/datatables/buttons.bootstrap4.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/datatables/jszip.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/datatables/pdfmake.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/datatables/vfs_fonts.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/datatables/buttons.html5.min.js"></script>
	<script src="${pageContext.request.contextPath}/plugins/datatables/buttons.print.min.js"></script>
	<!-- Responsive examples -->
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/dataTables.responsive.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/responsive.bootstrap4.min.js"></script>

     <!-- Parsley js -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/plugins/parsleyjs/parsley.min.js"></script>

	<!--  App js -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.core.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.app.js"></script>
	<%-- <script src="${pageContext.request.contextPath}/js/script.js"></script> --%>

	<!-- Init Js file -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/pages/jquery.form-advanced.init.js"></script>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.33.1/sweetalert2.js"></script>
	 
	 <script type="text/javascript">
		$(document).ready(function() {
			$('form').parsley();
		});
		
		$('#reset').click(function () {
		    $('form').parsley().reset();
		});
		
		$('#form').on('submit', function() {
	         return $('#testForm').jqxValidator('validate');
	     });
		$("form").on('submit',function(){
			if($("#emailExistErrorMsg").text()!=""){
				return false;
			}
			else{
				$("#emailExistErrorMsg").text("");
				return true;
			}
		});
	function checkMailExist(email){
	   
		 $.ajax({
             url: "${pageContext.request.contextPath}/checkEmailExistOrNot",
             type: "GET", 
               data: { 'email': email},
             success: function(response)
                         {
            	   var statuscode=response.statusCode
            	   if(statuscode=="1"){
            		 $("#emailExistErrorMsg").text("Email Already Exist!");
            		 $("#emailExistErrorMsg").css("display","inline");
            		 $("#emailExistErrorMsg").css("position","absolute");
            	     } 
            	 else{
            		 $("#emailExistErrorMsg").text("");
            		 $("#emailExistErrorMsg").css("display","none");
            		 $("#emailExistErrorMsg").css("position","absolute");
            	 }
            	 }
                         
			
		});
		 
		       $("#reset").on("click",function(){
	         	if($("#emailExistErrorMsg").text()!="")
	         		{
	         		$("#emailExistErrorMsg").text("");
	         		}
	         });
		}
	</script>
</body>
</html>