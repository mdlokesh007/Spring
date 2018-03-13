<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
       <form:form method="post" action="editsave">    
        <table >    
         <tr> <form:hidden path="userId"/>   
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>Phone :</td>    
          <td><form:input path="phone" /></td>  
         </tr>   
         <tr>    
          <td>City :</td>    
          <td><form:input path="city" /></td>  
         </tr>   
         <tr>    
          <td colspan="2"><input type="submit" value="Edit" /></td>    
         </tr>    
        </table>    
       </form:form>  