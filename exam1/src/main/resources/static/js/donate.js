var table;

$(document).ready( function () {
 	initializeDatatable();
 	attachFormAction();
});

function initializeDatatable(){
	table = $('#donationsTable').DataTable({
			"sAjaxSource": "/donations",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "id"},
				{ "mData": "amount" },
				{ "mData": "response" }
			]
 	});
}


function attachFormAction(){
	$('#donationForm').on('submit', function (event) {

		event.preventDefault();
		let formData = new FormData($(this)[0]);
		$.ajax({
			url: $(this).attr('action'),
			data: formData,
			processData: false,
			contentType: false,
			cache: false,
			type: 'POST',
			success: function (response) {
				bootbox.alert({
				message:response,
			    callback: function (result) {
			        table.ajax.reload();
			    }});
				
			},
			error: function(error){
				bootbox.alert(error);
			}
		});
	
	});
}