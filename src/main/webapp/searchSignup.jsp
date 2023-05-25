<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kuebiko.it.servlet.dto.SignupDTO"%>
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
   	<h1>Search Signup Page</h1>
   	 <img style="height: 160px;" src="img/search.png">
   	  <img style="height: 160px;" src="img/search.png">
   	   <img style="height: 160px;" src="img/search.png">
   	 <br/><br/>
   	 
   	 
   	
   	 <form action="searchSignup" method="post">
   	 
   	 <div style="width: 50%;margin-bottom: 15px;" class="form-group">
   		 <label>Search Data : </label>
   		 <input type="text" name="textSearch" class="form-control">
   		  <h4 style="color:red;">${message}</h4>
   	 </div>
   	 
   	 	 <div style="width: 50%;margin-top: 20px;">
   	 <button type="submit" name="bbutton" value="search" class="btn btn-primary">Search</button>
   	        <button type="submit" name="bbutton" value="clear" class="btn btn-success">Clear</button>
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
	signupDTOs=new ArrayList<SignupDTO>();
}
for(SignupDTO signupDTO :signupDTOs ){
%>  
      <tr>
      <td><%=signupDTO.getSid() %></td>
        <td><%=signupDTO.getName() %></td>
       <td><%=signupDTO.getEmail() %></td>
      <td><%=signupDTO.getGender() %></td>
        <td>
              <button type="button" class="btn btn-danger">D</button>
                <a href="editData?sid=<%=signupDTO.getSid() %>"> 
               <button type="button" class="btn btn-primary">E</button>
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