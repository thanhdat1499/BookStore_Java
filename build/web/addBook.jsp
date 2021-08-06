<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>
<%@include file="navbarAdmin.jsp" %>

<div id="content" class="site-content">
    <div id="primary" class="content-area column full">
        <main id="main" class="site-main" role="main">

            
            <form action="AdminInsertBookController" method="POST">
                Book Name: <input type="text" name="txtName" value="" /><br/>
                Author: <input type="text" name="txtAuthor" value="" /><br/>
                Price: <input type="text" name="txtPrice" value="" /><br/>
                Quantity: <input type="text" name="txtQuantity" value="" /><br/>
                Image: <input type="text" name="txtImages" value="" /><br/>
                Description: <input type="text" name="txtDes" value="" /><br/>
                Category Id: <input type="text" name="txtCateId" value="" /><br/>
                <input type="submit" name="action" value="Insert" />
            </form>


        </main>
        <!-- #main -->
    </div>
    <!-- #primary -->
</div>
<!-- #content -->

<%@include file="footer.jsp" %>