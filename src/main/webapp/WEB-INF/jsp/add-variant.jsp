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
        <meta http-equiv="X-UA-Compatible" content="IE=edge" content="no-cache" />

        <!-- App favicon -->
        <link rel="shortcut icon"
	href="${pageContext.request.contextPath}/design/images/DQI-icon.png">

        <!-- App css -->
        <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/assets/css/metismenu.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />

        <script src="${pageContext.request.contextPath}/assets/js/modernizr.min.js"></script>
        
        <style>
.gm-style-mtc,.gm-svpc
{
display: none;
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
                                   <!--  <li class="breadcrumb-item"><a href="#">Mystery</a></li>
                                    <li class="breadcrumb-item"><a href="#"></a></li> -->
                                </ol>
                            </div>
                            <h4 class="page-title">Create Variant</h4>
                        </div>
                    </div>
                </div>

                <div class="row">
                <jsp:include page="include/tab.jsp"></jsp:include>
        
                <div class="col-lg-6">

                        <div class="card-box ">
                            <h4 class="header-title m-t-0">  </h4>
                            <form method="POST" action="${pageContext.request.contextPath}/saveVariant" autocomplete="off">
                            
                                 <div class="form-group col-md-12">
                                    <label for="state_name">Brand Name<span class="text-danger">*</span></label>
									<select id="brand_id" name="brand_id" required class="form-control" onchange="getModelsByBrandId(this.value);" >
									<option value="">Select Brand</option>
                                    <c:forEach var="variant" items="${activeBrandList}">
                                     <option value="${variant.sk_brand_id }">${variant.brand_name }</option>
                                     </c:forEach>
                                     </select>                           
                                 </div>
                                 <div class="form-group col-md-12">
                                    <label for="model_name">Model Name<span class="text-danger">*</span></label>
									<select id="model_id" name="model_id" required class="form-control"  >
									 <option value="">Select Model</option>
                                     </select>                           
                                 </div>
                                <div class="form-group col-md-12">
                                    <label for="variant_name">Variant Name<span class="text-danger">*</span></label>
                                    <input type="text" required class="form-control"  onkeyup="checkVariantExistOrNot(this.value)" id="varient_name" name="variant_name" placeholder="Enter Varient Name"   data-parsley-maxlength="100">
                                <span id="varianterrormsg" style="color:red"></span>
                                 <input type="text"   id="testbox" style="display: none">
                                </div>
                                
                                <div class="form-group text-right m-b-0">
                                    <button class="btn btn-gradient waves-effect waves-light btnsubmit" type="submit">
                                        Submit
                                    </button>
                                    <button type="reset" id="reset" class="btn btn-light waves-effect m-l-5" >
                                        Reset
                                    </button>
                                    
                                </div>

                            </form>
                        </div> <!-- end card-box -->
                    </div>
                    
                    
                     <div class="col-md-6">
                        <div class="card-box table-responsive">
                            <h4 class="m-t-0 header-title"><b> </b></h4>
                           

                            <ul class="nav nav-tabs">
                                        <li class="nav-item">
                                            <a href="#activestates" data-toggle="tab" aria-expanded="true" class="nav-link active">
                                                Active Variants
                                            </a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="#inactivestates" data-toggle="tab" aria-expanded="false" class="nav-link ">
                                                Inactive Variants
                                            </a>
                                        </li>
                                    </ul>
                                      <div class="tab-content">
                                        <div class="tab-pane fade show active" id="activestates">
                                         <table id="datatable-buttons" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                <tr>
                                    <th>Brand Name</th>
                                    <th>Model Name</th>
                                    <th>Variant Name</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                 <c:forEach var="variant" items="${activeVariantList}">
                                <tr>
                                    <td>${variant.brand.brand_name }</td>
                                     <td>${variant.model.model_name }</td>
                                    <td>${variant.variant_name }</td>
                                    <td><a href="${pageContext.request.contextPath}/editVariant/${variant.sk_variant_id}" class="fa fa-edit"></a>&nbsp;&nbsp;&nbsp;<a href="#"  class="fa fa-trash" data-id="${variant.sk_variant_id}" data-toggle="modal" data-target="#myModal"></a></td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                                        </div>
                                        <div class="tab-pane fade  " id="inactivestates">
                                         <table id="datatable-buttons" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                <tr>
                                    <th>Brand Name</th>
                                    <th>Model Name</th>
                                    <th>Varient Name</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="variant" items="${inactiveVariantList}">
                                <tr>
                                    <td>${variant.brand.brand_name }</td>
                                     <td>${variant.model.model_name }</td>
                                    <td>${variant.variant_name}</td>
                                    <td><a href="#" data-restoreid="${variant.sk_variant_id}" data-toggle="modal" data-target="#myModal1" title="Restore the Variant" class="mdi mdi-backup-restore"></a></td> 
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                                        </div>
                                       
                                    </div>
                        </div>
                    </div>
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
            	var value=$(this).attr("data-id");
            	var url="${pageContext.request.contextPath}/deleteVariant/"+value;
            	$(".btn-edit").attr("href",url);
            });
            
            $(".mdi-backup-restore").on("click",function(){
            	var value=$(this).attr("data-restoreid");
            	var url="${pageContext.request.contextPath}/restoreVariant/"+value;
            	$(".btn-restore").attr("href",url);
            });
            
        </script>
   
   
     <script>
        jQuery(document).ready(function() {
	// 3 Capitalize string every 1st chacter of word to uppercase
	jQuery('#model_name').keyup(function() 
	{
		var str = jQuery('#model_name').val();
		var spart = str.split(" ");
		for ( var i = 0; i < spart.length; i++ )
		{
			var j = spart[i].charAt(0).toUpperCase();
			spart[i] = j + spart[i].substr(1);
		}
      jQuery('#model_name').val(spart.join(" "));
	
	});
	
});
       
        </script>       
        
      <!-- - Variant Exist Or Not -->
        <script type="text/javascript">
        function checkVariantExistOrNot(variant_name){
        	var brand_id=$("#brand_id").val();
        	var model_id=$("#model_id").val();
         	 $.ajax({
                  url: "${pageContext.request.contextPath}/checkVariantExistOrNot",
                  type: "GET", 
                    data: { 'name': name,'model_id':model_id ,'brand_id':brand_id},
                  success: function(response)
                              {
                	  var statusCode=response.statusCode;
          	          var status=response.status
					   if(statusCode=="1" && status=="active"){
						   $("#varianterrormsg").text("Variant already exists ...!")
					   }
					   else if(statusCode=="0" && status=="inactive")
					   {
						   $("#varianterrormsg").text("Variant already exists in Inactive tab Please restore it ...!")
					   }
					   
					   else{
					
						   $("#varianterrormsg").text("");
					   }
                              }
        	  });
         }
        $("#reset").on("click",function(){
            if($("#varianterrormsg").text()!="")
              {
              $("#varianterrormsg").text("");
              }
          });
        </script>
      <script>
$("form").on('submit',function(){
    if($("#varianterrormsg").text()!=""){
      return false;
    }
    else{
      $("#varianterrormsg").text("");
      return true;
    }
  });
</script>
<script>
        function getModelsByBrandId(brand_id) 
          { 
         $("#model_id option").remove();  
        	 $.ajax({
                  url: "${pageContext.request.contextPath}/getModelsByBrandId",
                  type: "GET", 
                    data: { 'brand_id': brand_id },
                  success: function(response)
                              {
                	  $("#model_id").append("<option value=''>Select Model</option>");
                	  $.each(response,function(k,v){
                          $("#model_id").append("<option value='"+v.sk_model_id+"'>"+v.model_name+"</option>");

                	  });
                                    
                              }
                  });  
         
        }
        </script>
        
</body>
</html>