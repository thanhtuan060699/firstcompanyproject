$('#btnDeleteContactModal').click(function(e) {
		var contactIds = $('#contactList').find(
				'tbody input[type=checkbox]:checked').map(function() {
			return $(this).val();
		}).get();
		if(contactIds.length!=0){
			$('#deleteContactModal').modal();
		}
	
	
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
		url : "/company/api-contact",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			if(response==1){
				alert("You successfully deleted");
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
document.addEventListener("DOMContentLoaded",function(){
	var btnContact=document.getElementsByClassName('btnContactEdit');
	 for(var i=0;i<btnContact.length;i++){
		 btnContact[i].onclick=function(){
			 var id=parseInt(this.getAttribute("data-id"));
			 window.location.href="/company/contact-account?action=EDIT&id="+id;
		 }
	 } 
	
},false);