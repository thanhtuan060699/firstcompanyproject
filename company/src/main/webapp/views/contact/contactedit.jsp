<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingAPI" value="/api-building"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edit Contact</title>
	</head>

	<body>
		<div class="main-content">
			<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li class="active">Edit Contact</li>
						</ul><!-- /.breadcrumb -->
					</div>
					
					<div class="page-content">
						<div class="row">
							<div class="col-xs-3" style="text-align: center;">
								
							</div>
							<div class="col-xs-8 alert-enter" style="text-align: center;" >
								
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<form action="" role="form" class="form-horizontal" id="formEdit">
									<div class="form-group">
										<label for="name" class="col-sm-3 control-label no-padding-right">Name</label>
										<div class="col-sm-8">
											<input type="text" id="name" class="form-control" name="name" value="${contact.name }">
										</div>
									</div>
									
									<div class="form-group">
											<label for="ward" class="col-sm-3 control-label no-padding-right" >Email</label>
											<div class="col-sm-8">
												<input type="text" id="email" class="form-control" name="email" value="${contact.email}">
											</div>
									</div>
									<div class="form-group">
											<label for="street" class="col-sm-3 control-label no-padding-right">Phone Number</label>
											<div class="col-sm-8">
												<input type="text" id="phoneNumber" class="form-control" name="phoneNumber" value="${contact.phoneNumber}"> 
											</div>
									</div>
									<div class="form-group">
											<label class="col-sm-3 control-label no-padding-right"></label>
											<div class="col-sm-8">
											<button type="button" class="btn btn-primary" id="btnUpdateContact">Edit Contact</button>
										
											</div>
									</div>
									
								</form>
							</div><!-- /.col -->
						</div><!-- /.row -->
					
			</div><!-- /.page-content -->
		</div>
		</div>
		<script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
		<script src="<c:url value='/template/admin/js/contact-edit.js' />"></script>
	</body>

	</html>