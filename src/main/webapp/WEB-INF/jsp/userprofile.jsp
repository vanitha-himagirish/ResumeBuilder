<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>

<html>
   <head>
    	<meta charset="UTF-8">
       		<title>User Profile </title>
        	<link href="webjars/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
    </head>
    
<body>

<form action="userprofile_submit"  method="post" class="needs-validation" novalidate>

<div class="container">
 	 <div class="form-row">
    	<div class="form-group col-md-6">
      		<label for="txtUserName">User Name</label>
      		<input type="text" class="form-control" id="txtUserName" name="txtUserName" placeholder="User Name" required>
      		<div class="invalid-feedback">
        		Please provide User Name
      		</div>
    	</div>
    	<div class="form-group col-md-6">
      		<label for="inputPassword4">Password</label>
      		<input type="password" class="form-control" id="txtPassword" name="txtPassword" placeholder="Password" required>
    	</div>
 	  	<div class="form-group col-md-6">
    	  	<label for="txtUserName">First Name</label>
      		<input type="text" class="form-control" id="txtFirstName" name="txtFirstName" placeholder="First Name" required>
    	</div>
    	<div class="form-group col-md-2">
      		<label for="txtMiddleName">Middle Name</label>
      		<input type="text" class="form-control" id="txtMiddleName" name="txtMiddleName" placeholder="Middle Name">
    	</div>
    	<div class="form-group col-md-4">
      		<label for="txtLastName">Last Name</label>
      		<input type="text" class="form-control" id="txtLastName" name="txtLastName" placeholder="Last Name" required>
    	</div>
 		<div class="form-group col-md-6">
    		<label for="txtAddress">Address</label>
    		<input type="text" class="form-control" id="txtAddress" name="txtAddress" placeholder="1234 Main St">
  		</div>
  		<div class="form-group col-md-6">
    		<label for="txtAddress2">Address 2</label>
    		<input type="text" class="form-control" id="txtAddress2" name="txtAddress2" placeholder="Apartment, studio, or floor">
  		</div>
    	<div class="form-group col-md-6">
      		<label for="txtCity">City</label>
      		<input type="text" class="form-control" id="txtCity" name="txtCity">
    	</div>
    	<div class="form-group col-md-3">
    		<label for="cmbState">State</label>    		
      		<form:select path="states" name="cmbState">
    			<option value="Select" label="Choose a State"></option>
    			<form:options items="${states}" />
			</form:select> 
      	</div>
    	<div class="form-group col-md-3">
      		<label for="txtZip">Zip</label>
      		<input type="text" class="form-control" id="txtZip" name="txtZip">
    	</div>
  	</div>
	 <div style="float:right">
 		 <input type="submit" class="btn btn-primary" name="btnSubmit" placeholder="Next">
 	</div>
	</div>
 </form>

</body>
</html>
<script>
// Disable form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Get the forms we want to add validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>