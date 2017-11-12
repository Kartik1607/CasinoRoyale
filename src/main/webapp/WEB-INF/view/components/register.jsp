<div style="min-width:300px; max-width:800px; margin: auto auto;">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="post" action="/register" modelAttribute="user" enctype="multipart/form-data">
	<div class="form-group row">
		<form:label path="name" class="col-sm-2 col-form-label" for="name">Name</form:label>
    	<div class="col-sm-10">
    		<form:input path="name" class="form-control" id="name" placeholder="Name" required="required"/>
    	</div>
  	</div>
	
	<div class="form-group row">
		<form:label path="dateOfBirth" class="col-sm-2 col-form-label" for="dateOfBirth">Date of Birth</form:label>
    	<div class="col-sm-10">
    		<form:input type="date" path="dateOfBirth" class="form-control" id="dateOfBirth" placeholder="Date of Birth" required="required"/>
    	</div>
  	</div>
  	
  	<div class="form-group row">
		<form:label path="emailAddress" class="col-sm-2 col-form-label" for="emailAddress">Email Address</form:label>
    	<div class="col-sm-10">
    		<form:input type="email" path="emailAddress" class="form-control" id="emailAddress" placeholder="Email Address" required="required"/>
    	</div>
  	</div>
  	
  	<div class="form-group row">
		<form:label path="contactNumber" class="col-sm-2 col-form-label" for="contactNumber">Contact Number</form:label>
    	<div class="col-sm-10">
    		<form:input type="number" path="contactNumber" class="form-control" id="contactNumber" placeholder="Contact Number" required="required"/>
    	</div>
  	</div>
  	
  	<div class="form-group row">
    	<form:label path="idProof" for="idProof" class="col-sm-2 col-form-label">Identity Proof</form:label>
    	<form:input path="idProof" type="file" class="form-control-file" id="idProof" />
  	</div>
  	
  	<button class="btn btn-primary" type="submit">Register</button>
  	
</form:form>




<!-- 
<form action="/abc" method="POST">
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" placeholder="Name">
    </div>
  </div>
  <div class="form-group row">
    <label for="dateOfBirth" class="col-sm-2 col-form-label">Date of Birth</label>
    <div class="col-sm-10">
      <input type="date" class="form-control" id="dateOfBirth">
    </div>
  </div>
  <div class="form-group row">
    <label for="contactNumber" class="col-sm-2 col-form-label">Contact</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" id="contactNumber">
    </div>
  </div>
  <div class="form-group row">
    <label for="emailAddress" class="col-sm-2 col-form-label">Email Address</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="emailAddress">
    </div>
  </div>
  
  
  <div class="form-group row">
    <label for="IdProof" class="col-sm-2 col-form-label">Identity Proof</label>
    <input type="file" class="form-control-file" id="IdProof">
  </div>
   
  
  <button type="submit" class="btn btn-primary">Register</button>
</form>
 -->
</div>
