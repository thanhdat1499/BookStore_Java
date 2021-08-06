
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>

<div id="content" class="site-content">
                    <div id="primary" class="content-area column full">
                        <main id="main" class="site-main" role="main">

                            
                            <ul class="products row">
                                
                                <c:forEach items="${listBook}" var="dto">
                                
                                   
                                <li class="product col-3">
                                   
                                    <a href="paging">
                                        <img class="img-fluid" src="images/${dto.image}" alt="">
                                        <h3 >${dto.bookName}</h3>
                                        <span class="price" ><span class="amount"><font color="blue">${dto.price}</font></span></span>
                                    </a>
                                    
                                    
                                        <form action="MainController" method="POST">    
                                            
                                            <input name="bookId" type="hidden" value="${dto.bookId}">
                                            <input name="action" type="submit" value="Add to cart" class="button">

                                        </form>
                                </li>

                                </c:forEach>

                            </ul>
                            <nav class="pagination">
                                    <c:forEach begin="1" end="${numberPage}" var="i">
                                        <a class="page-numbers" href="paging?index=${i}">${i}</a>
                                    </c:forEach>
                                </nav>
                                
				<br/>

                        </main>
                        <!-- #main -->
                    </div>
                    <!-- #primary -->
                </div>
                <!-- #content -->

<%@include file="footer.jsp" %>
