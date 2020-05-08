$(document).ready(function() {
	$("#success").hide();
	$("#fail").hide();
});
var call = {
	createProduct : function() {

		var data = {};
		data["name"] = $("#nameMotorbike").val();
		data["description"] = $("#description").val(); 
		data["automakerId"] = $("#automakerId").val();
		
		data["categoryId"] = $("#categoryId").val();
		data["cc"] = $("#cc").val();
		date["colorId"] = $("#colorId").val();
//		data["name"] = "tiến"; automakeId, categoryId,  description,cc
//		console.log(cc);
		
//		var $form = $('#motorbike')[0];
//
//		var data = new FormData($form);
		$.ajax({
			url : "/api/post/products",
			type : "post",
			contentType : "application/json", // dữ liệu gửi lên
			//timeout : 1000000,
			// RestAPI có dạng là
			// json.
			data : JSON.stringify(data), // object json -> string json

			dataType : "json", // dữ liệu từ Rest trả về là json.
			success : function(jsonResult) { // được gọi khi web-service trả
				    $("#fail").hide();
					$("#success").show();
			},
			error: function(e){
				
					$("#fail").show();
					$("#success").hide();
				
		    }
		});
	}
}