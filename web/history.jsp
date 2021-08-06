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
                            <th>Date</th>
                            <th>Discount Id</th>
                            <th>Total Price</th>
                            <th>Action</th>
                        </tr>
                    </thead>



                    <tbody>
                        <c:forEach var="dto" items="${listOrder}" varStatus="counter">
                            <tr>

                                <td>${counter.count}</td>
                                <td>${dto.orderId}</td>
                                <td>${dto.createDate}</td>
                                <td>${dto.discountId}</td>
                                <td>${dto.totalPrice}</td>
 
                                <td>

                                    <a href="ViewDetailController?orderId=${dto.orderId}">Detail</a>
                                    
                                    
                                </td>


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