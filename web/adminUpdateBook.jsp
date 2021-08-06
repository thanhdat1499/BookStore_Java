<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>
<%@include file="navbarAdmin.jsp" %>

<div id="content" class="site-content">
                    <div id="primary" class="content-area column full">
                        <main id="main" class="site-main" role="main">
                            
                            <form action="AdminUpdateBookController" method="POST">
                                <input type="hidden" name="txtId" value="${id}"/><br/>
                                Book Name: <input type="text" name="txtName" value="${name}"/><br/>
                                Author: <input type="text" name="txtAuthor" value="${author}"/><br/>
                                Price: <input type="text" name="txtPrice" value="${price}"/><br/>
                                Quantity: <input type="text" name="txtQuantity" value="${quantity}"/><br/>
                                Image: <input type="text" name="txtImages" value="${images}"/><br/>
                                Description: <input type="text" name="txtDes" value="${description}"/><br/>
                                <input type="submit" name="action" value="Update"/>
                                
                            </form>
                            

                        </main>
                        <!-- #main -->
                    </div>
                    <!-- #primary -->
                </div>
                <!-- #content -->

<%@include file="footer.jsp" %>

