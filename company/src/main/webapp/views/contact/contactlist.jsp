<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp"%>
 <c:url var="customerURL" value="/admin-customer"/>
 <c:url var="userAPI" value="/api-user"/>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List Contact</title>
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
															<form action="/company/contact-account" method="get" id="formSearchCustomer">
															<div class="form-group">
																<div class="col-sm-4">
						
																	<input type="text" id="searchKey" class="form-control" name="searchKey" placeholder="Search Contact"
																	value="${textSearch }" style="height: 42px">
																</div>
																<div class="col-sm-8">
																			
																		  <input type="submit" value="Search" class="btn btn-primary" style="" /> 
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
											<a></a>
											<tr >
													<td><input type="checkbox" value="${item.id}" id="check_box1"></td>
													
													<td  class="btnContactEdit" data-id="${item.id}" style="cursor: pointer;">${item.name}</td>
													<td  class="btnContactEdit" data-id="${item.id}" style="cursor: pointer;">${item.email}</td>
													<td  class="btnContactEdit" data-id="${item.id}" style="cursor: pointer;">${item.phoneNumber}</td>
												
													
													<td>
												
														<a  href='<c:url value='/contact-account?action=EDIT&id=${item.id}'/>'>
															<button class="btn btn-info btn-xs" data-toggle="tolltip"
														 title="Edit Contact"  >
															<i class="fa fa-pencil" aria-hidden="true"></i>
															</button>
														</a>
														
													</td>
												</tr>
												
											</c:forEach>			
											</tbody>
										</table>
								</div>
								<c:if test="${ not empty emptyResults}">
								<div class="col-xs-12" style="text-align: center;font-size: 25px">
									<p>Don't have any results</p>
								</div>
								</c:if>
								

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
				  <h4 class="modal-title" style="text-align: center;">Do you want to delete that contacts ?</h4>
				</div>
				
				<div class="modal-footer" style="text-align: center;">
				  <button type="button" class="btn btn-danger" data-dismiss="modal" id="btnDeleteContact">YES</button>
				  <button type="button" class="btn btn-info" data-dismiss="modal">NO</button>
				</div>
			  </div>
			</div>
		</div>
		<script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
		<script src="<c:url value='/template/admin/js/contact-delete.js' />"></script>
	</body>

	</html>