<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>

<div id="content" class="site-content">
    <div id="primary" class="content-area column full">
        <main id="main" class="site-main" role="main">


            
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Order Id</th>
                            <th>Book Id</th>
                            <th>Book Name</th>
                            <th>Book Price</th>
                            <th>Bought Quantity</th>
                        </tr>
                    </thead>


                    <tbody>
                        <c:forEach var="dto" items="${listDetail}" varStatus="counter">
                            <tr>

                                <td>${counter.count}</td>
                                <td>${dto.orderId}</td>
                                <td>${dto.bookId}</td>
                                <td>${dto.bookName}</td>
                                <td>${dto.bookPrice}</td>
                                <td>${dto.boughtQuantity}</td>


                            </tr>
                        </c:forEach>

                        
                    </tbody>
                </table>
            

        </main>
        <!-- #main -->
    </div>
    <!-- #primary -->
</div>
<!-- #content -->

<%@include file="footer.jsp" %>