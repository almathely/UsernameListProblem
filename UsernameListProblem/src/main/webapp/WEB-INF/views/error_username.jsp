<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Username List Problem - Username List</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row" style="margin-top:100px;">
       <div class="col-sm-3">
	    
	    </div>
	    <div class="col-sm-6">
	    	<c:if test="${!empty invalidUser}">
	    	    <div class="alert alert-danger">
				  <strong>${invalidUser}</strong> 
				</div>
	        </c:if>
	        <c:if test="${empty invalidUser}">
	            <div class="alert alert-danger">
				  <strong>There was an error adding the username. The username already exist.</strong> 
				</div>
	        </c:if>
	    </div>
	    <div class="col-sm-3">
	    
	    </div>
    </div>
    
    
    <c:if test="${empty invalidUser}">
    	
		
		<div class="row" style="margin-top:50px;">
    		<div class="col-sm-3">
		    
		    </div>
		    <div class="col-sm-3" style="text-align:center;">
		       <a href="getAllUsernames">Go Back Username List</a>
		    </div>
		    <div class="col-sm-3" style="text-align:center;">
		        <a href="newUsername">New Username</a>
		    </div>
	        <div class="col-sm-3">
		    
		    </div>
		</div>
		
		<div class="row" style="margin-top:50px;">
    		<div class="col-sm-3">
		    
		    </div>
		    <div class="col-sm-6" style="text-align:center;">
		        <h3>Suggested Username List</h3>
		    </div>
	        <div class="col-sm-3">
		    
		    </div>
		</div>
		
	    <div class="row" style="margin-top:50px;">
		    <div class="col-sm-3">
		    
		    </div>
		    <div class="col-sm-6">
		    	<table border="1" class="table-striped" width="100%">
	 			<tr>
	                 <th>Value</th>
	            </tr>
	 
	            <c:forEach var="username" items="${listSuggestedUSernames}">
	                <tr>
	                    <td class="col-md-8">${username}</td>
	                </tr>
	            </c:forEach>
	        </table>
		    </div>
		    <div class="col-sm-3">
		    
		    </div>
	    </div>
    </c:if>
</div>

</body>
</html>