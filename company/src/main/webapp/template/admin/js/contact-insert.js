$(btnAddContact).click(function(){
	var data={};
	var formData=$('#formEdit').serializeArray();
	$.each(formData,function(index,v){
		data[""+v.name+""]=v.value;
	});
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/company/api-contact",
		data: JSON.stringify(data),
		dataType: "json",
		contentType:"application/json",

		success: function (response) {
			if(response==1){
				alert('You successfully inserted')
				window.location.href="/company/contact-account?action=LIST";
			}
			
		},
		error: function (response) {
			console.log('failed');
			console.log(response);
		}
	});
	location.reload(true);
	
})
