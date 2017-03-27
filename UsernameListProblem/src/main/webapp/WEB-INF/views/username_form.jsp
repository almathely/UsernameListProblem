<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Username List Problem - New Username</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- jQuery Validator -->
<script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <div class="row">
       <div class="col-sm-3">
	    
	    </div>
	    <div class="col-sm-6" style="text-align:center;">
	    	<h3>New Username</h3>
	    </div>
	    <div class="col-sm-3">
	    
	    </div>
    </div>
    
    <div class="row" style="margin-top;100px;">
       <div class="col-sm-3">
	    
	    </div>
	    <div class="col-sm-6">
	    	<form:form action="saveUsername" method="post" modelAttribute="username" id="username">
	            <form:hidden path="id"/>
	            <div class="form-group">
	                <label for="value">Value:</label>
    				<form:input path="value" class="form-control" id="value" name="value"/>
	            </div>
	            <button type="submit" class="btn btn-info">Submit</button>
	            <a href="getAllUsernames" class="btn btn-default" role="button">Cancel</a>
	        </form:form>
	    </div>
	    <div class="col-sm-3">
	    
	    </div>
    </div>
    
</div>

<script>
$(function() {
  $("#username").validate({
    // Specify validation rules
    rules: {
      value: {
        required: true,
        minlength: 6
      }
    },
    // Specify validation error messages
    messages: {
      password: {
        required: "Please provide a Username",
        minlength: "Your username must be at least 6 characters long"
      }
    },

    submitHandler: function(form) {
      form.submit();
    }
  });
});
</script>
</body>
</html>