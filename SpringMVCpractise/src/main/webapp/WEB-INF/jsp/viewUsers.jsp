 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Phone</th><th>City</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="user" items="${list}">   
   <tr>  
   <td>${user.userId}</td>  
   <td>${user.name}</td>  
   <td>${user.phone}</td>  
   <td>${user.city}</td>  
   <td><a href="edituser/${user.userId}">Edit</a></td>  
   <td><a href="deleteuser/${user.userId}">Delete</a></td> 
   </tr>  
   </c:forEach>  
   </table>  