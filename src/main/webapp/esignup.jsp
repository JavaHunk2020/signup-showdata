<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.p1.SignupDTO"%>
<%@page import="java.util.List"%>
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <header style="height: 30px;background-color:yellow; ">
   </header>
   
   <section class="container">
   	<h1>Edit Signup Page</h1>
   	 <img style="height: 160px;" src="https://s40424.pcdn.co/in/wp-content/uploads/2022/03/What-is-project-management-Meaning-and-Definition-of-Project-Management-1.jpg">
   	  <img style="height: 160px;" src="https://s40424.pcdn.co/in/wp-content/uploads/2022/03/What-is-project-management-Meaning-and-Definition-of-Project-Management-1.jpg">
   	   <img style="height: 160px;" src="https://s40424.pcdn.co/in/wp-content/uploads/2022/03/What-is-project-management-Meaning-and-Definition-of-Project-Management-1.jpg">
   	 <br/><br/>
   	 
   	 
   	 <h1 style="color:green;">${message}</h1>
   	 <form action="usignup" method="post">
   	 
   	 <input type="hidden" name="sid" class="form-control" value="${signupDTO.sid}">
   	 
   	 <div style="width: 50%;margin-bottom: 15px;" class="form-group">
   		 <label>Username : </label>
   		 <input type="text" name="username" class="form-control" value="${signupDTO.name}">
   	 </div>
   	 
   	 <div style="width: 50%;margin-bottom: 15px;" class="form-group">
   	 <label>Email : </label>
   	 <input type="email" name="email" class="form-control" value="${signupDTO.email}">
   	 </div>
   	 
   	 <div style="width: 40%;margin-bottom: 15px;" class="form-group">
   	 <label>Gender : </label>
   	 
   	 <select  name="gender" class="form-control">
   	    <option ${signupDTO.gender=='Male'?'selected':''}>Male</option>
   	    <option  ${signupDTO.gender=='Female'?'selected':''}>Female</option>
   	 </select>
   	 </div>
   	 
   	 	 <div style="width: 50%;margin-top: 20px;">
   	 <button type="submit" class="btn btn-primary">Update</button>
   	  <button type="reset" class="btn btn-danger">Clear</button>
   	  
   	    
   	 </div>
   	 </form>
   	 <hr/>
   	
   </section>
 
</body>
</html>