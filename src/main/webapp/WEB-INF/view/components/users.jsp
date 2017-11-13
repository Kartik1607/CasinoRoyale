<%@include file="overlays/rechargeOverlay.jsp" %>
<div class="container">
	<form method="get" action="/search">
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="uid">ID</label> 
				<input name="UID" type="number" class="form-control" id="uid" placeholder="Unique ID">
			</div>
			
			<div class="form-group col-md-6">
				<label for="name">Name</label> 
				<input name="name" type="text" class="form-control" id="name" placeholder="Name">
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="email">Email Address</label> 
				<input name="emailAddress" type="text" class="form-control" id="email" placeholder="Email ID">
			</div>
			
			<div class="form-group col-md-6">
				<label for="contactNumber">Contact Number</label> 
				<input name="contactNumber" type="number" class="form-control" id="contactNumber" placeholder="Contact Number">
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>

	<table class="table table-hover my-5">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Name</th>
				<th scope="col">Date of Birth</th>
				<th scope="col">Contact</th>
				<th scope="col">Email</th>
				<th scope="col">Balance</th>
				<th scope="col">Recharge</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<th scope="row">${user.getId()}</th>
					<td>${user.getName()}</td>
					<td>${user.getDateOfBirth()}</td>
					<td>${user.getContactNumber()}</td>
					<td>${user.getEmailAddress()}</td>
					<td>${user.getBalanceAmount() }</td>
					<td>
						<button class="btn" onclick="showRechargeDialog(${user.getUid()});return false;">
							Recharge
						</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>