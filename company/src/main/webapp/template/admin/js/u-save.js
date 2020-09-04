$(btnAddUser).click(function(){
	var data={};
	var formData=$('#formEdit').serializeArray();
	$.each(formData,function(index,v){
		data[""+v.name+""]=v.value;
	});
	var role=$('#role').val();
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/homework/api-user",
		data: JSON.stringify(data),
		dataType: "json",
		contentType:"application/json",

		success: function (response) {
			if(response=="username"){
				window.location.href="/homework/admin-user?signal=EDIT&message=username";
			}
			else if(response==2){
				window.location.href="/homework/admin-user?signal=EDIT&message=confirmpassword";
			}
			else if(response==3){
				window.location.href="/homework/admin-user?action=LIST"
			}
		},
		error: function (response) {
			console.log('failed');
			console.log(response.val);
		}
	});
	
})