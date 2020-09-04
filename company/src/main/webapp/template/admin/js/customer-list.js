$('#btnSearchCustomer').click(function(e) {
			e.preventDefault();
			$('#formSearchCustomer').submit();
		});
function assignmentCustomer(userId) {
	openModalAssignmentCustomer();
	$('#userId').val(userId);
	showUserAssignment();
	
}

function openModalAssignmentCustomer() {
	$('#assignmentCustomerModal').modal();
}
$('#btnDeleteCustomer').click(
		function(e) {
			e.preventDefault();
			var data = {};
			var buildingIds = $('#customerList').find(
					'tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['customerIds'] = buildingIds;
			deleteCustomer(data);
		});
function deleteCustomer(data) {
	
	$.ajax({
		type : "DELETE",
		url : "http://localhost:8080/homework/api-customer?ar="+data.buildingIds,
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			
		},
		
	});
	window.location.href="/homework/admin-customer?action=LIST";
	
}
function showUserAssignment() {
	var data={};
	data['userId'] = $('#userId').val();
	$.ajax({
		type:"GET",
		url : "http://localhost:8080/homework/api-assignment-customer?type=SHOW_STAFF_USER&customerId="+$('#userId').val(),
		dataType : "json",
		contentType:"application/json",
		success : function(response) {
			var  html= '';
			$.each(response,function(key,values){
				html+= '<tr>';
				if(values.checked=='check'){
					html+= '<td><input type="radio" name="user" value="'+values.id+'" id="checkbox_2"  checked="checked" /></td>';
				}
				else{
					html+= '<td><input type="radio" name="user" value="'+values.id+'" id="checkbox_2" /></td>';
				}
					
				html+='<td>'+values.fullname+ '</td>';
				html+= '</tr>';
			})
			$('#staffCList tbody').html(html);
			console.log('success');
			console.log(response);
		},
		error : function(response) {
			console.log('failed');
			console.log(response);
		}
	});
}
$('#btnAssignCustomer').click(
		function(e) {
			e.preventDefault();
			var data = {};
			data['id'] = $('#userId').val();
			var staffs = $('#staffCList').find(
					'tbody tr td input[type=radio]:checked').map(function() {
				return $(this).val();
			}).get();
			data['staffId'] = staffs;
			assignCustomer(data);
		});

function assignCustomer(data) {
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/homework/api-assignment-customer?customerId="+data.userId+"&userId="+data.staffs,
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			console.log('success');
		},
		error : function(response) {
			console.log('failed');
			console.log(response);
		}
	});
}
