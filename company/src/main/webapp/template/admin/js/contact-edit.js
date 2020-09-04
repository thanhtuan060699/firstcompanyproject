function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}
$(btnUpdateContact).click(function(){
	var data={};
	var formData=$('#formEdit').serializeArray();
	$.each(formData,function(index,v){
		data[""+v.name+""]=v.value;
	});
	data['id']=getUrlVars()["id"];
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/company/api-contact",
		data: JSON.stringify(data),
		dataType: "json",
		contentType:"application/json",

		success: function (response) {
			console.log(response);
			if(response==1){
				alert('You successfully updated')
				window.location.href="/company/contact-account?action=LIST";
			}
			
		},
		error: function (response) {
			console.log('failed');
			console.log(response.value);
		}
	});
	
})