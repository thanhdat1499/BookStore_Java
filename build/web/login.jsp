<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="header.jsp" %>
<%@include file="navbar.jsp" %>

<div id="content" class="site-content">
                    <div id="primary" class="content-area column full">
                        <main id="main" class="site-main" role="main">

                            <form action="MainController" method="POST">
                                Username: <input type="text" name="txtUsername"/>
                                <font color="red">
                                
                                </font>
                                <br/>
                                Password: <input type="password" name="txtPassword"/><br/>
                                <font color="red">
                                  ${err}
                                </font>
                                <br/>
                               
                                <input type="submit" name="action" value="Login"/>
                            </form>
                            <a href="createAccount.jsp"><font color="blue">
                                  Create new account
                                </font></a>

                        </main>
                        <!-- #main -->
                    </div>
                    <!-- #primary -->
                </div>
                <!-- #content -->

<%@include file="footer.jsp" %>
