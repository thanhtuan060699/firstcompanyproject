$(btnAddContact).click(function(){
	var data={};
	var formData=$('#formEdit').serializeArray();
	$.each(formData,function(index,v){
		data[""+v.name+""]=v.value;
	});
	$.ajax({
		type: "POST",
		url: "/company/api-contact",
		data: JSON.stringify(data),
		dataType: "json",
		contentType:"application/json",

		success: function (response) {
			console.log('success');
			if(response==1){
				
				window.location.href="/company/contact-account?action=LIST";
			}
			if(response==2){
				var alert=document.getElementsByClassName('alert-enter')[0];
				alert.innerHTML='<div class="alert alert-warning">You need to enter email and phone number</div>';
			}
			if(response==3){
				var alert=document.getElementsByClassName('alert-enter')[0];
				alert.innerHTML='<div class="alert alert-warning">You need to enter email </div>';
			}
			if(response==4){
				var alert=document.getElementsByClassName('alert-enter')[0];
				alert.innerHTML='<div class="alert alert-warning">You need to enter phone number </div>';
			}
			if(response==5){
				var alert=document.getElementsByClassName('alert-enter')[0];
				alert.innerHTML='<div class="alert alert-warning">Your phone number or email existed !!! Please enter another one </div>';
			}
			if(response==6){
				var alert=document.getElementsByClassName('alert-enter')[0];
				alert.innerHTML='<div class="alert alert-warning">Your email is wrong!!! Please enter another one </div>';
			}
			if(response==7){
				var alert=document.getElementsByClassName('alert-enter')[0];
				alert.innerHTML='<div class="alert alert-warning">Your phone number is wrong!!! Please enter another one </div>';
			}
			
		},
		error: function (response) {
			console.log('failed');
			console.log(response);
		}
	});
	
})

