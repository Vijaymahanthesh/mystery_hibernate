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
                            <h4 class="page-title">Create Brand</h4>
                        </div>
                    </div>
                </div>

                <div class="row">
                <jsp:include page="include/tab.jsp"></jsp:include>
        
                <div class="col-lg-6">

                        <div class="card-box ">
                            <h4 class="header-title m-t-0">  </h4>
                            <form method="POST" action="${pageContext.request.contextPath}/saveBrand" autocomplete="off">
                                
                                 <div class="form-group col-md-12">
                                    <label for="state_name">Brand Name<span class="text-danger">*</span></label>
                                    <input type="text" required   class="form-control" onkeyup="checkBrandExist(this.value)" id="brand_name" name="brand_name" placeholder="Enter Brand Name" value="${brandDetails.brand_name }" data-parsley-pattern="^[a-zA-Z ]+$"  data-parsley-maxlength="100">
                                    <input type="hidden" required   class="form-control" name="sk_brand_id" placeholder="Enter Brand Name"  value="${brandDetails.sk_brand_id }">
                                 <span id="branderrormsg" style="color:red"></span>
                                 <input type="text"   id="testbox" style="display: none">
                                </div>
                                <div class="form-group col-md-12">
                                    <label for="state_name">Brand Description<span class="text-danger">*</span></label>
                                    <input type="text" required   class="form-control"  id="brand_description" name="brand_description" placeholder="Enter Brand Description" value="${brandDetails.brand_description}"  data-parsley-maxlength="100">
                                  <span id="branderrormsg" style="color:red"></span>
                                 <input type="text"   id="testbox" style="display: none">
                                </div>
                                <div class="form-group text-right m-b-0">
                                    <button class="btn btn-gradient waves-effect waves-light btnsubmit" type="submit">
                                        Update
                                    </button>
                                    <a href="${pageContext.request.contextPath}/addBrand"><button type="submit" class="btn btn-light waves-effect m-l-5" id="reset" >
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
            $('#reset').click(function () {
    		    $('form').parsley().reset();
    		});
            
            $(".fa-trash").on("click",function(){
            	var sk_brand_id=$(this).attr("data-id");
            	var url="${pageContext.request.contextPath}/deleteBrand/"+sk_brand_id;
            	$(".btn-edit").attr("href",url);
            })
             $(".mdi-backup-restore").on("click",function(){
            	var sk_brand_id=$(this).attr("data-restoreid");
            	var url="${pageContext.request.contextPath}/restoreBrand/"+sk_brand_id;
            	$(".btn-restore").attr("href",url);
            });
        </script>
        
        
         <script>
        jQuery(document).ready(function() {
	// 3 Capitalize string every 1st chacter of word to uppercase
	jQuery('#brand_name').keyup(function() 
	{
		var str = jQuery('#brand_name').val();
		var spart = str.split(" ");
		for ( var i = 0; i < spart.length; i++ )
		{
			var j = spart[i].charAt(0).toUpperCase();
			spart[i] = j + spart[i].substr(1);
		}
      jQuery('#brand_name').val(spart.join(" "));
	
	});
	
});
        $(".btnsubmit").on("click",function(){
      	  $('form').parsley();
        	if($("#branderrormsg").text()=="Brand is  already exists ...!"){
        		
        		 $("#testbox").prop('required',true);
        		 setTimeout(function(){
           			var id=$("#testbox").attr("data-parsley-id");
           			  $("#parsley-id-"+id+"").hide();
           		}, 10);
        	}else	if($("#branderrormsg").text()=="Brand is in Inactive tab ,Please restore ...!"){
        		 $("#testbox").prop('required',true);
        		 setTimeout(function(){
           			var id=$("#testbox").attr("data-parsley-id");
           			  $("#parsley-id-"+id+"").hide();
           		}, 10);
        	}
        		else{
        		 $("#testbox").prop('required',false);
        	}
         
       });
      </script>       
      
      <script type="text/javascript">
      function checkBrandExist(name){
    	  var brand_name=$("#brand_name").val();
      	 $.ajax({
               url: "${pageContext.request.contextPath}/checkBrandExistOrNot",
               type: "GET", 
                 data: { 'brand_name': brand_name},
               success: function(response)
                           {
             	        var statusCode=response.statusCode;
					   if(statusCode=="1"){
						   $("#branderrormsg").text("Brand   already exists ...!")
					   }else{
					var id=$("#testbox").attr("data-parsley-id");
				   $("#parsley-id-"+id+"").remove();
						   $("#branderrormsg").text("");
					   }
                           }
     	  });
      	 
      	 $("#reset").on("click",function(){
	         	if($("#branderrormsg").text()!="")
	         		{
	         		$("#branderrormsg").text("");
	         		}
	         });
      }
      </script> 
      <script>
$("form").on('submit',function(){
    if($("#modelerrormsg").text()!=""){
      return false;
    }
    else{
      $("#modelerrormsg").text("");
      return true;
    }
  });
</script>  
      
</body>
</html>