<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
    
        <meta charset="utf-8" />
        <title>Mystery</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta content="A fully featured admin theme which can be used to build CRM, CMS, etc." name="description" />
        <meta content="Coderthemes" name="author" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

       <!-- App favicon -->
        <link rel="shortcut icon"
	href="${pageContext.request.contextPath}/design/images/DQI-icon.png">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/lugma_favicon.png">
		
		<link href="${pageContext.request.contextPath}/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
        <!-- DataTables --> 
        <link href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/plugins/datatables/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
         <!-- Responsive datatable examples -->
        <link href="${pageContext.request.contextPath}/plugins/datatables/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        
        <!-- Custom box css -->
        <link href="${pageContext.request.contextPath}/plugins/custombox/css/custombox.min.css" rel="stylesheet">

        <!-- App css -->
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/assets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />

        <script src="${pageContext.request.contextPath}/assets/js/modernizr.min.js"></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/nice-select.css" type="text/css" />
		
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
		
		
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
                                <!--     <li class="breadcrumb-item"><a href="#">Stock</a></li>
                                    <li class="breadcrumb-item"><a href="#">Settings</a></li> -->
                                </ol>
                            </div>
                            <h4 class="page-title">Edit Region</h4>
                        </div>
                    </div>
                </div>

                <div class="row">
                <jsp:include page="include/tab.jsp"></jsp:include>
        
                <div class="col-lg-6">

                        <div class="card-box ">
                            <h4 class="header-title m-t-0">  </h4>
                            <form method="POST" action="${pageContext.request.contextPath}/saveRegion"autocomplete="off">
                                <div class="form-group col-md-12">
                                    <label for="state_name">City Name<span class="text-danger">*</span></label>
									<select id="city_id" name="city_id" required class="form-control"  data-parsley-errors-container="#chke">
									<option value="" >Select City</option>
                                    <c:forEach var="region" items="${cityActiveList}">
                                     <option value="${region.sk_city_id}" <c:if test = "${region.sk_city_id == regionDetails.city_id}">selected </c:if>>${region.city_name }</option>
                                     </c:forEach>
                                     </select>  
                                     <div id="chke"></div>                         
                                 </div>
                                <div class="form-group col-md-12">
                                    <label for="state_name">Region Name<span class="text-danger">*</span></label>
                                     <input type="text" required onkeyup="CheckRegionExistOrNot(this.value)"  class="form-control" id="region_name" name="region_name" value="${regionDetails.region_name}" placeholder="Enter Region Name"  data-parsley-maxlength="100" >
                                      <input type="hidden"class="form-control" id="sk_region_id" name="sk_region_id" value="${regionDetails.sk_region_id}" placeholder="Enter Region Name"  data-parsley-maxlength="100" >
                                <span id="regionerrorMessage" style="color:red"></span>
                                 <input type="text"   id="testbox" style="display: none">
                                 </div>
                                
                               
                                
                                <div class="form-group text-right m-b-0">
                                    <button class="btn btn-gradient waves-effect waves-light btnsubmit" type="submit">
                                        Update
                                    </button>
                                    <a href="${pageContext.request.contextPath}/addRegion"><button type="submit" class="btn btn-light waves-effect m-l-5 resetbtn" id="reset" >
                                        Cancel
                                    </button></a>
                                    
                                </div>

                            </form>
                        </div> <!-- end card-box -->
                    </div>
                </div>
                <!-- end row -->

            </div> <!-- end container -->
        </div>
        </div></div>
       
                           
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
        
<%--         <script src="${pageContext.request.contextPath}/plugins/bootstrap-inputmask/bootstrap-inputmask.min.js" type="text/javascript"></script>
 --%>        <script src="${pageContext.request.contextPath}/plugins/autoNumeric/autoNumeric.js" type="text/javascript"></script>

        <!--  App js -->
        <script src="${pageContext.request.contextPath}/assets/js/jquery.core.js"></script>
        <script src="${pageContext.request.contextPath}/assets/js/jquery.app.js"></script>
        <script src="${pageContext.request.contextPath}/js/script.js"></script>
          
        <!-- Init Js file -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/pages/jquery.form-advanced.init.js"></script>
        <!-- Parsley js -->
        <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/parsleyjs/parsley.min.js"></script>
        
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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
        
        $('#reset').click(function () {
		    $('form').parsley().reset();
		    $('#state_id').empty();
		});        
        $(".fa-trash").on("click",function(){
        	var value=$(this).attr("data-id");
        	var url="${pageContext.request.contextPath}/deleteRegion/"+value;
        	$(".btn-edit").attr("href",url);
        });
        
        $(".mdi-backup-restore").on("click",function(){
        	var value=$(this).attr("data-restoreid");
        	var url="${pageContext.request.contextPath}/restoreRegion/"+value;
        	$(".btn-restore").attr("href",url);
        });
        
    </script>

        
         <script>
        jQuery(document).ready(function() {
	// 3 Capitalize string every 1st chacter of word to uppercase
	jQuery('#region_name').keyup(function() 
	{
		var str = jQuery('#region_name').val();
		var spart = str.split(" ");
		for ( var i = 0; i < spart.length; i++ )
		{
			var j = spart[i].charAt(0).toUpperCase();
			spart[i] = j + spart[i].substr(1);
		}
      jQuery('#region_name').val(spart.join(" "));
	
	});
	
});
       
      </script>       
      
      <script type="text/javascript">
      function CheckRegionExistOrNot(region_name){
    		var city_id=$("#city_id").val();
      	 $.ajax({
               url: "${pageContext.request.contextPath}/CheckRegionExistOrNot",
               type: "GET", 
                 data: { 'region_name': region_name,'city_id':city_id},
               success: function(response)
                           {
            	   var statusCode=response.statusCode;
       	        var status=response.status
				   if(statusCode=="1" && status=="active"){
					   $("#regionerrorMessage").text("Region already exists ...!")
				   }
				   else if(statusCode=="0" && status=="inactive")
				   {
					   $("#regionerrorMessage").text("Region already exists in Inactive tab Please restore it ...!")
				   }
				   
				   else{
				
					   $("#regionerrorMessage").text("");
				   }
                           }
     	  });
      }
      $(".resetbtn").on("click",function(){
      	var id=$("#testbox").attr("data-parsley-id");
			   $("#parsley-id-"+id+"").remove();
					   $("#errormsg").text("");
					   $("#testbox").prop('required',false);
      });
      </script>
        
        
        
      
</body>
</html>