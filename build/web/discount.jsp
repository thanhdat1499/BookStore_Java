<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>

<div id="content" class="site-content">
                    <div id="primary" class="content-area column full">
                        <main id="main" class="site-main" role="main">
                            <h2>DO YOU HAVE ANY DISCOUNT CODE?</h2>
                            <form action="CheckDiscountController" method="POST">
                                Discount Name: <input type="text" name="discountName"/><br/>
                                <p><font color="red">
                                ${invalidDiscount} ${notFound}
                                    </font></p>
                                <br/>
                                
                                <input type="submit" name="action" value="Pay"/>
                                <p><font color="green">
                                ${done} ${totalBill}
                                    </font></p>
                                <br/>
                            </form>
                            

                        </main>
                        <!-- #main -->
                    </div>
                    <!-- #primary -->
                </div>
                <!-- #content -->

<%@include file="footer.jsp" %>