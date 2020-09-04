	$('#btnAddLand').click(function(){
					var data={};
					var buildingTypes=[];
					var formData=$('#formEdit').serializeArray();
					$.each(formData,function(index,v){
						data[""+v.name+""]=v.value;
					});
		
					$.ajax({
						type: "GET",
						url: "http:/localhost:8080/homework/api-land",
						data: JSON.stringify(data),
						dataType: "json",
						contentType:"application/json",

						success: function (response) {
							window.location.href="/homework/admin-land?action=LIST"
						},
						error: function (response) {
							window.location.href="/admin-land"
						}
					});
				});