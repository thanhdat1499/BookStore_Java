<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>

<div id="content" class="site-content">
                    <div id="primary" class="content-area column full">
                        <main id="main" class="site-main" role="main">
                            
                            <form action="CreateAccountController" method="POST">
                                
                                User Name: <input type="text" name="txtUserName" /><br/>
                                Password: <input type="password" name="txtPassword" /><br/>
                                Full Name: <input type="text" name="txtFullName"/><br/>
                                Address: <input type="text" name="txtAddress" /><br/>
                                Phone: <input type="text" name="txtPhone" /><br/>
                                
                                <input type="submit" name="action" value="Sign in"/>
                                
                            </form>
                            

                        </main>
                        <!-- #main -->
                    </div>
                    <!-- #primary -->
                </div>
                <!-- #content -->

<%@include file="footer.jsp" %>