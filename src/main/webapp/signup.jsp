<!DOCTYPE html>
<%@page import="com.kuebiko.it.servlet.dto.SignupDTO"%>
<%@page import="java.util.ArrayList"%>
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
   	<h1>Signup Page</h1>
   	 <img style="height: 160px;" src="https://s40424.pcdn.co/in/wp-content/uploads/2022/03/What-is-project-management-Meaning-and-Definition-of-Project-Management-1.jpg">
   	  <img style="height: 160px;" src="https://s40424.pcdn.co/in/wp-content/uploads/2022/03/What-is-project-management-Meaning-and-Definition-of-Project-Management-1.jpg">
   	   <img style="height: 160px;" src="https://s40424.pcdn.co/in/wp-content/uploads/2022/03/What-is-project-management-Meaning-and-Definition-of-Project-Management-1.jpg">
   	 <br/><br/>
   	 
   	 
   	 <h1 style="color:green;">${message}</h1>
   	 <form action="signup" method="post">
   	 
   	 <div style="width: 50%;margin-bottom: 15px;" class="form-group">
   		 <label>Username : </label>
   		 <input type="text" name="username" class="form-control">
   	 </div>
   	 
   	 <div style="width: 50%;margin-bottom: 15px;" class="form-group">
   	 <label>Email : </label>
   	 <input type="email" name="email" class="form-control">
   	 </div>
   	 
   	 <div style="width: 40%;margin-bottom: 15px;" class="form-group">
   	 <label>Gender : </label>
   	 <select  name="gender" class="form-control">
   	    <option>Male</option>
   	    <option>Female</option>
   	 </select>
   	 </div>
   	 
   	 	 <div style="width: 50%;margin-top: 20px;">
   	 <button type="submit" class="btn btn-primary">Signup</button>
   	  <button type="reset" class="btn btn-danger">Clear</button>
   	  
   	    <a href="showData">
   	       <button type="button" class="btn btn-success">Show Data</button>
   	    </a>
   	       <a href="searchSignup.jsp">
   	       <button type="button" class="btn btn-primary">Search</button>
   	    </a>
   	 </div>
   	 </form>
   	 <hr/>
   	 <table class="table table-bordered">
    <thead>
      <tr style="background-color: maroon;color:white;">
         <th>Sno</th>
        <th>Name</th>
        <th>Email</th>
        <th>Gender</th>
          <th>Action</th>
      </tr>
    </thead>
    <tbody>
	
<%
// req.setAttribute("bananas", signupDTOs);
List<SignupDTO>  signupDTOs =(List<SignupDTO>)request.getAttribute("bananas");

if(signupDTOs==null){
	signupDTOs=new ArrayList<>();
}
for(SignupDTO signupDTO :signupDTOs ){
%>  
      <tr>
      <td><%=signupDTO.getSid() %></td>
        <td><%=signupDTO.getName() %></td>
       <td><%=signupDTO.getEmail() %></td>
      <td><%=signupDTO.getGender() %></td>
        <td>
          <a href="deleteData?sid=<%=signupDTO.getSid()%>">
              <button type="button" class="btn btn-danger">DELETE</button>
          </a>
          </td>
      </tr>
   
   <%
   }
%>   
      
      
      
      <tr style="background-color: green;">
      <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
      </tr>
    </tbody>
  </table>
   </section>
 
</body>
</html>