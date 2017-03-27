<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Username List Problem - Restricted Word List</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
       <div class="col-sm-3">
	    
	    </div>
	    <div class="col-sm-6" style="text-align:center;">
	    	<h1>Restricted Word List</h1>
	    </div>
	    <div class="col-sm-3">
	    
	    </div>
    </div>
        
    <div class="row" style="margin-top:100px;">
       <div class="col-sm-3">
	    
	    </div>
       <div class="col-sm-6" style="text-align:right;">
	    	<a href="newRestrictedWord" class="btn btn-info" role="button">New Restricted Word</a>
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
                 <th>Actions</th>
            </tr>
 
            <c:forEach var="restrictedWord" items="${listRestrictedWord}">
                <tr>
                    <td class="col-md-8">${restrictedWord.value}</td>
                    <td class="col-md-2"><a href="editRestrictedWord?id=${restrictedWord.id}">Edit</a>
                             <a
                        href="deleteRestrictedWord/${restrictedWord.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
	    </div>
	    <div class="col-sm-3">
	    
	    </div>
    </div>
    
    <div class="row">
       <div class="col-sm-3">
	    
	    </div>
	    <div class="col-sm-6" style="text-align:center;">
	    	<h3><a href="/UsernameListProblem">Go Back...</a></h3>
	    </div>
	    <div class="col-sm-3">
	    
	    </div>
    </div>
    
</div>
</body>
</html>