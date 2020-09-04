$('#btnDeleteUser').click(
		function(e) {
			e.preventDefault();
			var data = {};
			var buildingIds = $('#customerList').find(
					'tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['ids'] = buildingIds;
			deleteUser(data);
		});
function deleteUser(data) {
	
	$.ajax({
		type : "DELETE",
		url : "http://localhost:8080/homework/api-user?ar="+data.buildingIds,
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success: function (response) {
			if(response==1){
				window.location.href="/homework/admin-user?action=LIST";
			}
			
		},
		error: function (response) {
			console.log('failed');
			console.log(response.val);
		}
		
	});
	window.location.href="/homework/admin-user?action=LIST";
	
}