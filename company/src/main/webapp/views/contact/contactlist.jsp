<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp"%>
 <c:url var="customerURL" value="/admin-customer"/>
 <c:url var="userAPI" value="/api-user"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Danh sách khách hàng</title>
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
								<a href="#">List contact</a>
							</li>
						
						</ul><!-- /.breadcrumb -->
					</div>

					<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="row">
									<div class="col-xs-12 col-sm-12">
											<div class="widget-box">
												<div class="widget-header">
													<h4 class="widget-title">Searching</h4>

													<div class="widget-toolbar">
														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>
													</div>
												</div>

												<div class="widget-body">
													<div class="widget-main">
														<div class="form-horizontal">
															<form action="${customerURL}" method="get" id="formSearchCustomer">
															<div class="form-group">
																<div class="col-sm-4">
																	<label for="name">Name</label>
																	<input type="text" id="name" class="form-control" name="name">
																</div>
																<div class="col-sm-4">
																	<label for="numberPhone">Email</label>
																	<input type="text" id="phoneNumber" class="form-control" name="phoneNumber">
																</div>
																<div class="col-sm-4">
																	<label for="numberOfBasement">Phone Number</label>
																	<input type="text" id="address" class="form-control" name="address">
																</div>
															</div>
															
															<div class="form-group">
																	<div class="col-sm-8">
																	<c:forEach var="item" items="${buildingTypes}" >
																		<label class="checkbox-inline">
																		<input type="checkbox" value="${item.key }" id="buildingTypes" name="buildingTypes"
																				${fn:contains(fn:join(model.buildingTypes,','),item.key)?'checked' :'' }>${item.value }
																		</label>
																	</c:forEach>									
																	</div>
															</div>
															<div class="form-group">
																	<div class="col-sm-8">
																			<button type="button" class="btn btn-primary" id="btnSearchCustomer">Search</button>
																	</div>		
															</div>
															<input type="hidden" value="LIST" name="action" />
														</form>
														</div>
													</div>
												</div>
											</div>
										</div>
								</div>
	
								</div><!-- /.row -->
								<div class="col-xs-12"> <!--  nut -->
							
									<div class="pull-right">
										<a  href='<c:url value='/contact-account?action=INSERT'/>' class="btn btn-white btn-info btn-bold" data-toggle="tolltip" title="Insert Contact">
											<i class="fa fa-plus-circle" aria-hidden="true"></i>
										</a>
										<button class="btn btn-white btn-warning btn-bold" data-toggle="tolltip" title="Delete contact" id="btnDeleteContactModal">
											<i class="fa fa-trash" aria-hidden="true"></i>
										</button>
										
									</div>
									
								</div>
					
								<div class="col-xs-12">
										<table id="contactList" class="table table-striped table-bordered table-hover">
											<thead>
												<tr>
													<th >
												   </th>
													<th>Name</th>
													<th>Email</th>
													<th>Phone Number</th>
													<th>Manipulation</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="item" items="${contacts}">
											<tr>
													<td><input type="checkbox" value="${item.id}" id="check_box1"></td>
													<td>${item.name}</td>
													<td>${item.email}</td>
													<td>${item.phoneNumber}</td>
													
													
													<td>
												
														<a  href='<c:url value='/contact-account?action=EDIT&id=${item.id}'/>'>
															<button class="btn btn-info btn-xs" data-toggle="tolltip"
														 title="Edit Contact"  >
															<i class="fa fa-refresh" aria-hidden="true"></i>
															</button>
														</a>
														
													</td>
												</tr>
											</c:forEach>			
											</tbody>
										</table>
								</div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
		</div>
		<div id="deleteContactModal" class="modal fade" role="dialog">
			<div class="modal-dialog">
		  
			  <!-- Modal content-->
			  <div class="modal-content">
				<div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  <h4 class="modal-title" style="text-align: center;">Bạn có muốn xóa hay không ?</h4>
				</div>
				
				<div class="modal-footer" style="text-align: center;">
				  <button type="button" class="btn btn-danger" data-dismiss="modal" id="btnDeleteContact">Xóa</button>
				  <button type="button" class="btn btn-info" data-dismiss="modal">Hủy</button>
				</div>
			  </div>
			</div>
		</div>
	</body>

	</html>