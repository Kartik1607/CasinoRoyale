function showRechargeDialog(uid) {
	console.log(uid);
	$('#rechargeInputUserID').val(uid);
	$('#rechargeModal').modal('show');
}

function doRecharge() {
	console.log('Inside');
	var uid = $('#rechargeInputUserID').val();
	var amount = + ($('#rechargeInputAmount').val());
	console.log(uid);
	console.log(typeof amount);
	if(amount < 0) {
		console.log('in');
		$('#rechargeInputAmount').addClass('is-invalid');
	} else {
		
	}
} 