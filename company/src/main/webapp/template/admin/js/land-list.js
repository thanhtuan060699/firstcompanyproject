function assignmentBuilding(buildingId) {
	openModalAssignmentBuilding();
	$('#buildingId').val(buildingId);
	showStaffAssignment();
	
}
function openModalAssignmentBuilding() {
	$('#assignmentBuildingModal').modal();
}

$('#btnAssignBuilding').click(
		function(e) {
			e.preventDefault();
			var data = {};
			data['id'] = $('#buildingId').val();
			var staffs = $('#staffList').find(
					'tbody tr td input[type=radio]:checked').map(function() {
				return $(this).val();
			}).get();
			data['staffs'] = staffs;
			assignStaff(data);
		});

function assignStaff(data) {
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/homework/api-assignment-land?id="+data.buildingId+"&ar="+data.staffs,
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
function showStaffAssignment() {
	var data={};
	data['buildingId'] = $('#buildingId').val();
	$.ajax({
		type:"GET",
		url : "http://localhost:8080/homework/api-assignment-land?type=SHOW_STAFF_ASSIGNMENT&landId="+$('#buildingId').val(),
		dataType : "json",
		contentType:"application/json",
		success : function(response) {
			var  html= '';
			$.each(response,function(key,values){
				html+= '<tr>';
				if(values.checked=='check'){
					html+= '<td><input type="radio" name="land" value="'+values.id+'" id="checkbox_2" checked/></td>';
				}
				else{
					html+= '<td><input type="radio" name="land" value="'+values.id+'" id="checkbox_2" /></td>';
				}
					
				html+='<td>'+values.fullname+ '</td>';
				html+= '</tr>';
			})
			$('#staffList tbody').html(html);
			console.log('success');
			console.log(response);
		},
		error : function(response) {
			console.log('failed');
			console.log(response);
		}
	});
}
$('#btnDeleteBuilding').click(
		function(e) {
			e.preventDefault();
			var data = {};
			var buildingIds = $('#buildingList').find(
					'tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['ids'] = buildingIds;
			deleteBuilding(data);
		});
function deleteBuilding(data) {
	$.ajax({
		type : "DELETE",
		url : "http://localhost:8080/homework/api-land?ar="+data.buildingIds,
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			if(response==1){
				alert("Xóa thành công")
				window.location.href="/homework/admin-land?action=LIST";
			}
		},
		error : function(response) {
			console.log('failed');
			console.log(response);
			location.reload(true);
		}
		
	});
	window.location.href="/homework/admin-land?action=LIST";
}
$('#btnSearchBuilding').click(function(e) {
			e.preventDefault();
			$('#formSearchBuilding').submit();
		});


