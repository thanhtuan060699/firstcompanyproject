function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}
$(btnPasswordUser).click(function(){
	var data={};
	var formData=$('#formEdit').serializeArray();
	$.each(formData,function(index,v){
		data[""+v.name+""]=v.value;
	});
	
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/homework/api-user-password",
		data: JSON.stringify(data),
		dataType: "json",
		contentType:"application/json",

		success: function (response) {
			console.log(response);
			if(response==1){
				window.location.href="/homework/admin-user?signal=PASSWORD&message=missing";
			}
			else if(response==2){
				window.location.href="/homework/admin-user?signal=PASSWORD&message=confirmpassword";
				
			}else if(response==3){
				window.location.href="/homework/admin-user?signal=PASSWORD&message=previouspassword";
			}else if(response==4){
				window.location.href="/homework/admin-user?signal=PASSWORD&message=samepassword";
			}
			else if(response==5){
				alert("Thay đổi mật khẩu thành công");
				window.location.href="/homework/admin-user?action=LIST";
			}
		},
		error: function (response) {
			console.log('failed');
			console.log(response.value);
		}
	});
	
})