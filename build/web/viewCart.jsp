
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>

<div id="content" class="site-content">
    <div id="primary" class="content-area column full">
        <main id="main" class="site-main" role="main">


            <form action="UpdateBuyingQuantityController" method="POST">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Book Name</th>
                            <th>Price</th>
                            <th>Buying Quantity</th>
                            <th>Action</th>
                        </tr>
                    </thead>



                    <tbody>
                        <c:forEach var="dto" items="${shoppingCart}" varStatus="counter">
                            <tr>

                                <td>${counter.count}</td>
                                <td>${dto.bookName}</td>
                                <td>${dto.price}</td>
                                <td>
                                    <input type="text" name="txtBuyingQuantity" value="${dto.buyingQuantity}"/>
                                    <input type="hidden" name="txtID" value="${dto.bookId}"/>
                                </td>
                                <td>

                                    <a href="RemoveInCartController?bookId=${dto.bookId}"  onclick="return confirm('Are you sure to remove this book from your cart')">Delete</a>

                                </td>


                            </tr>
                        </c:forEach>

                        <tr>
                            <td></td>

                            <td>Total Price</td>
                            <td>${totalPrice}</td>
                            <td>
                                <input type="submit" name="action" value="Update"/>
                            </td>
                            <td>
                                <a href="CheckQuantityController">Confirm</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>

        </main>
        <!-- #main -->
    </div>
    <!-- #primary -->
</div>
<!-- #content -->

<%@include file="footer.jsp" %>