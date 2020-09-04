$('#btnDeleteContactModal').click(function(e) {
	$('#deleteContactModal').modal();
	
});
$('#btnDeleteContact').click(
		function(e) {
			e.preventDefault();
			var data = {};
			var contactIds = $('#contactList').find(
					'tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['ids'] = contactIds;
			deleteContact(data);
		});
function deleteContact(data) {
	$.ajax({
		type : "DELETE",
		url : "http://localhost:8080/company/api-contact",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			if(response==1){
				alert("Xóa thành công")
				location.reload(true);
			}
		},
		error : function(response) {
			console.log('failed');
			console.log(response);
			location.reload(true);
		}
		
	});
	
}