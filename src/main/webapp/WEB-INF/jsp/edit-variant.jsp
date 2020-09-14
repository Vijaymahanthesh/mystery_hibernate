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
                                    <c:forEach var="brandBean" items="${activeBrandList}">
                                    <option value="${brandBean.sk_brand_id}" <c:if test = "${brandBean.sk_brand_id == variantDetails.brand_id}">selected </c:if>>${brandBean.brand_name}</option>
                                    </c:forEach>
                                     </select>                           
                                 </div>
                                 <div class="form-group col-md-12">
                                    <label for="model_name">Model Name<span class="text-danger">*</span></label>
									<select id="model_id" name="model_id" required class="form-control"  >
									 <c:forEach var="modelBean" items="${activeModelList}">
									 <option value="${modelBean.sk_model_id}" <c:if test = "${modelBean.sk_model_id == variantDetails.model_id}">selected </c:if>>${modelBean.model_name}</option>
									 </c:forEach>
                                     </select>                           
                                 </div>
                                <div class="form-group col-md-12">
                                    <label for="variant_name">Variant Name<span class="text-danger">*</span></label>
                                    <input type="text" required class="form-control"  onkeyup="exist(this.value)" id="varient_name" name="variant_name" value="${variantDetails.variant_name}"placeholder="Enter Varient Name"   data-parsley-maxlength="100">
                                    <input type="hidden"  class="form-control" name="sk_variant_id" value="${variantDetails.sk_variant_id}"placeholder="Enter Varient Name"   data-parsley-maxlength="100">
                                    
                                <span id="varianterrormsg" style="color:red"></span>
                                 <input type="text"   id="testbox" style="display: none">
                                </div>
                                
                                <div class="form-group text-right m-b-0">
                                    <button class="btn btn-gradient waves-effect waves-light btnsubmit" type="submit">
                                        Update
                                    </button>
                                    <a href="${pageContext.request.contextPath}/addVariant"><button type="submit" id="reset" class="btn btn-light waves-effect m-l-5" >
                                        Cancel
                                    </button></a>
                                    
                                </div>

                            </form>
                        </div> <!-- end card-box -->
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
        $(".btnsubmit").on("click",function(){
        	  $('form').parsley();
          	if($("#modelerrormsg").text()=="Variant is  already exist in ...!"){
          		 $("#testbox").prop('required',true);
          		 setTimeout(function(){
             			var id=$("#testbox").attr("data-parsley-id");
             			  $("#parsley-id-"+id+"").hide();
             		}, 10);
          	}else	if($("#modelerrormsg").text()=="Variant is in Inactive tab ,Please restore ...!"){
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
        
      <!-- state existeor not -->
        <script type="text/javascript">
        function exist(name){
        	var model_id=$("#model_id").val();
         	 $.ajax({
                  url: "${pageContext.request.contextPath}/getVariantExistance",
                  type: "GET", 
                    data: { 'name': name,'model_id':model_id },
                  success: function(response)
                              {
                	  var msg=response.message;
                	 var statusmessage=response.status;
                	// alert(statusmessage)
  					   if(msg=="variantexist" && statusmessage=="active"){
  						   $("#varianterrormsg").text("Variant is  already exist in ...!")
  					   }else if(msg=="variantexist" && statusmessage=="inactive"){
  						   $("#varianterrormsg").text("Variant is in Inactive tab ,Please restore ...!")
  					   }else{
  					var id=$("#testbox").attr("data-parsley-id");
  				   $("#parsley-id-"+id+"").remove();
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