<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
    
        <meta charset="utf-8" />
        <title>MYS-Users</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

        <!-- App favicon -->
        <link rel="shortcut icon"
	href="${pageContext.request.contextPath}/design/images/DQI-icon.png">
		
		
		<link href="${pageContext.request.contextPath}/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
        <!-- DataTables --> 
        <link href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/plugins/datatables/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
         <!-- Responsive datatable examples -->
        <link href="${pageContext.request.contextPath}/plugins/datatables/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        
        <link href="${pageContext.request.contextPath}/assets/css/jquery.growl.css"
	rel="stylesheet" type="text/css" />
        <!-- Custom box css -->
        <link href="${pageContext.request.contextPath}/plugins/custombox/css/custombox.min.css" rel="stylesheet">

        <!-- App css -->
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/assets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/assets/css/nice-select.css" rel="stylesheet" type="text/css" />
        <script src="${pageContext.request.contextPath}/assets/js/modernizr.min.js"></script>
		
		
		<style>
		#userType{
		position: relative;
    	left: 20px;
		}
		#icon{
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
         <jsp:include page="include/modal.jsp"></jsp:include>
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
                            <h4 class="page-title">View Users</h4>
                        </div>
                    </div>
                </div>

                <div class="col-md-12">
                        <div class="card-box table-responsive">
                            <h4 class="m-t-0 header-title"><b> </b></h4>
                           

                            <ul class="nav nav-tabs">
                                        <li class="nav-item">
                                            <a href="#activestates" data-toggle="tab" aria-expanded="true" class="nav-link active">
                                                Active Users
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="#inactivestates" data-toggle="tab" aria-expanded="false" class="nav-link ">
                                                Inactive Users
                                            </a>
                                        </li>
                                    </ul>
                                      <div class="tab-content">
                                        <div class="tab-pane fade show active" id="activestates">
                                         <table id="datatable-buttons" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>
                                    <th>Mobile</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                               <c:forEach var="user" items="${userList}">
                                <tr>
                                    <td>${user.first_name }</td>
                                    <td>${user.last_name }</td>
                                    <td>${user.email }</td>
                                    <td>${user.mobile_number }</td>
                                    <td><a href="${pageContext.request.contextPath}/editUser/${user.sk_user_id}" class="fa fa-edit"></a>&nbsp;&nbsp;&nbsp;<a href="#"  class="fa fa-trash" data-id="${user.sk_user_id}" data-toggle="modal" data-target="#myModal"></a></td>
                                </tr>
                                </c:forEach> 
                                </tbody>
                            </table>
                                        </div>
                                        <div class="tab-pane fade  " id="inactivestates">
                                         <table id="datatable-buttons" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>
                                    <th>Mobile</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="user" items="${inactiveuserList}">
                                <tr>
                                     <td>${user.first_name }</td>
                                    <td>${user.last_name }</td>
                                    <td>${user.email }</td>
                                    <td>${user.mobile_number}</td>
                                    <td><a href="#" data-restoreid="${user.sk_user_id}" data-toggle="modal" data-target="#myModal1" title="Restore the USers" class="mdi mdi-backup-restore"></a></td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                                        </div>
                                       
                                    </div>
                        </div>
                    </div>
                <!-- end row -->

            </div> <!-- end container -->
        </div>
        </div></div>
       


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
        <script src="${pageContext.request.contextPath}/plugins/bootstrap-tagsinput/js/bootstrap-tagsinput.min.js"></script>
        <script src="${pageContext.request.contextPath}/plugins/select2/js/select2.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/plugins/bootstrap-select/js/bootstrap-select.js" type="text/javascript"></script>
        <!--  Required datatable js -->
        <script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap4.min.js"></script>
        <!-- Buttons examples -->
        <script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.buttons.min.js"></script>
        <script src="${pageContext.request.contextPath}/plugins/datatables/buttons.bootstrap4.min.js"></script>
        <script src="${pageContext.request.contextPath}/plugins/datatables/jszip.min.js"></script>
        <script src="${pageContext.request.contextPath}/plugins/datatables/pdfmake.min.js"></script>
        <script src="${pageContext.request.contextPath}/plugins/datatables/vfs_fonts.js"></script>
        <script src="${pageContext.request.contextPath}/plugins/datatables/buttons.html5.min.js"></script>
        <script src="${pageContext.request.contextPath}/plugins/datatables/buttons.print.min.js"></script>
        <!-- Responsive examples -->
        <script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.responsive.min.js"></script>
        <script src="${pageContext.request.contextPath}/plugins/datatables/responsive.bootstrap4.min.js"></script>


        <script
		src="${pageContext.request.contextPath}/assets/js/jquery.growl.js"></script>
        <!--  App js -->
        <script src="${pageContext.request.contextPath}/assets/js/jquery.core.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.app.js"></script>
        <script src="${pageContext.request.contextPath}/js/script.js"></script>
          
        <!-- Init Js file -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/pages/jquery.form-advanced.init.js"></script>
        <!-- Parsley js -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/parsleyjs/parsley.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function() {
                $('#datatable').DataTable();

                //Buttons examples
                var table = $('#datatable-buttons').DataTable({
                    lengthChange: false,
                    buttons: ['copy', 'excel', 'pdf']
                });

                table.buttons().container()
                        .appendTo('#datatable-buttons_wrapper .col-md-6:eq(0)');
            } );

        </script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('form').parsley();
            });
        </script>
        
     <script>
     $(".fa-trash").on("click",function(){
     	var value=$(this).attr("data-id");
     	var url="${pageContext.request.contextPath}/deleteUser/"+value;
     	$(".btn-edit").attr("href",url);
     });
     
     $(".mdi-backup-restore").on("click",function(){
     	var value=$(this).attr("data-restoreid");
     	var url="${pageContext.request.contextPath}/restoreUser/"+value;
     	$(".btn-restore").attr("href",url);
     });
     
     </script>      
</body>
</html>