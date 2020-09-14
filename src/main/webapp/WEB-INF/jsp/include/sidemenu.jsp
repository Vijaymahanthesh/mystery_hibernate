<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ page import="java.util.ResourceBundle"%>
<style>
.enlarged #wrapper #sidebar-menu .menu-title {
	display: block !important
}
</style>
<div class="left side-menu">
	<div class="slimscroll-menu" id="remove-scroll">
		<div id="sidebar-menu">
			<!-- Left Menu Start -->
			<ul class="metismenu" id="side-menu">
				<!-- <li><a href="#"><i
						class="fi-briefcase"></i> <span> Dashboard </span></a></li> -->
				<li><a href="javascript: void(0);"><i class="fa fa-users"></i>
						<span>User Management</span> <span class="menu-arrow"></span></a>
					<ul class="nav-second-level collapse" aria-expanded="false">
						<li><a href="${pageContext.request.contextPath}/createUser">Create
								User</a></li>

						<li><a href="${pageContext.request.contextPath}/viewUser">View
								User</a></li>

					</ul></li>
					
					
					<li><a href="javascript: void(0);"><i
						class="fa fa-database"></i>
						<span>Database Management</span> <span class="menu-arrow"></span></a>
					    <ul class="nav-second-level collapse" aria-expanded="false">
						<li><a href="${pageContext.request.contextPath}/addBrand">Manage Brand</a></li>
						
						
						<li><a href="javascript: void(0);">
						<span>Manage Model</span> <span class="menu-arrow"></span></a>
					<ul class="nav-third-level" aria-expanded="false">
						<li><a href="${pageContext.request.contextPath}/addModel">Manage Model</a></li>
						<li><a href="${pageContext.request.contextPath}/addVariant">Manage Variant</a></li> 

					</ul></li>
					
					<li><a href="javascript: void(0);">
						<span>Manage Region</span> <span class="menu-arrow"></span></a>
					<ul class="nav-third-level" aria-expanded="false">
						<li><a href="${pageContext.request.contextPath}/addState">Manage State</a></li>
						<li><a href="${pageContext.request.contextPath}/addCity">Manage City </a></li>
						<li><a href="${pageContext.request.contextPath}/addRegion">Manage Region</a></li>

					</ul></li>
					
					<li><a href="javascript: void(0);">
						<span>Manage Section</span> <span class="menu-arrow"></span></a>
					<ul class="nav-third-level" aria-expanded="false">
						<li><a href="${pageContext.request.contextPath}/addSection">Manage Section</a></li>
						<li><a href="${pageContext.request.contextPath}/addSubsection">Manage Subsection </a></li>
					</ul></li>
					
					
					</ul></li>
				
</ul>
		</div>
	</div>
</div>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
                    $("#slidebutton").css("transform","rotate(180deg)");
                    $("#slidebutton").click(function() {
                    	if (  $( "#slidebutton" ).css( "transform" ) == 'none' ){
                            $("#slidebutton").css("transform","rotate(180deg)");
                        } else {
                            $("#slidebutton").css("transform","" );
                        }
                      });
                   
                    </script>