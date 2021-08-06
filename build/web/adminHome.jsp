
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<%@include file="navbarAdmin.jsp" %>

<div id="content" class="site-content">
                    <div id="primary" class="content-area column full">
                        <main id="main" class="site-main" role="main">

                            
                            <ul class="products row">
                                
                                <c:forEach items="${listBookForAdmin}" var="dto">
                                
                                   
                                <li class="product col-3">
                                   
                                    <a>
                                        <img class="img-fluid" src="images/${dto.image}" alt="">
                                        <h3 >${dto.bookName}</h3>
                                        <span class="price" ><span class="amount"><font color="blue">${dto.price}</font></span></span>
                                    </a><br/>
                                    
                                    <a href="AdminUpdateController?updateId=${dto.bookId}">Update</a>
                                    <a href="AdminRemoveBookController?removeId=${dto.bookId}"  onclick="return confirm('Are you sure to remove this book')">Delete</a>
                                    
                                </li>

                                </c:forEach>

                            </ul>
                            <nav class="pagination">
                                    <c:forEach begin="1" end="${numberPage}" var="i">
                                        <a class="page-numbers" href="PageAdminController?index=${i}">${i}</a>
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
