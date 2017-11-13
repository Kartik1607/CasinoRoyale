<div class="modal fade" id="rechargeModal" tabindex="-1" role="dialog"
	aria-labelledby="rechargeModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="rechargeModalLabel">Recharge</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form>
					<label>Enter Amount to recharge</label>
					<div class="form-group">
						<label>User ID</label> <input class="form-control"
							id="rechargeInputUserID" type="text" disabled>
					</div>
					<div class="input-group">
						<span class="input-group-addon">Rs</span> <input
							id="rechargeInputAmount" name="amount" type="number"
							class="form-control" required>
						<div class="invalid-feedback" id="rechargeFeedback">
							<br> Please provide a valid city.
						</div>
						<span class="input-group-btn">
							<button class="btn btn-secondary" type="button"
								onclick="doRecharge()">Go!</button>
						</span>
					</div>


				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>