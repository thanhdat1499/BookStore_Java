<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><font color="red">SORRY, OUT OF STOCK!</font></h1>
        <ul>
        <c:forEach var="dto" items="${outOfStockk}">
            <li><a>The book store just has ${dto.quantity} ${dto.bookName} now!</a> </li> 
            
        </c:forEach>
        </ul>
    </body>
</html>
