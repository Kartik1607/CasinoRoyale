function showRechargeDialog(uid) {
	$('#rechargeInputUserID').val(uid);
	$('#rechargeModal').modal('show');
}

function showUserIdProof(idProof) {
	$('#userIDImg').attr('src','http://casino-admin.herokuapp.com/images/'+idProof);
	$('#userDetailModal').modal('show');
}

function doRecharge() {
	console.log('Inside');
	var uid = $('#rechargeInputUserID').val();
	var amount = + ($('#rechargeInputAmount').val());
	console.log(uid);
	console.log(typeof amount);
	if(amount < 0 || amount > 10000000 ) {
		console.log('in');
		$('#rechargeInputAmount').addClass('is-invalid');
		$('#rechargeFeedback').show();
	} else {
		var url = "http://casino-admin.herokuapp.com/api/recharge/" + uid + "?amount=" + amount;
		var xhr = new XMLHttpRequest();
		xhr.open("PUT", url, true);
		xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
		xhr.onload = function () {
			var res = JSON.parse(xhr.responseText);
			if (xhr.readyState == 4 && xhr.status == "200") {
				alert('New balance = ' + res.data.balanceAmount);
			} else {
				console.error(res);
			}
		}
		xhr.send(null);
	}
} 