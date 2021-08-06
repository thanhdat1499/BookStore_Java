
<nav id="site-navigation" class="main-navigation">
    <button class="menu-toggle">Menu</button>
    <a class="skip-link screen-reader-text" href="#content">Skip to content</a>
    <div class="menu-menu-1-container">
        <ul id="menu-menu-1" class="menu">

            
            
            <li><a href="paging">Shop</a></li>
            <li>

                <a href="ViewCartController">Cart
                </a></li>



            <c:if test="${sessionScope.account != null}" var="checkList">
                <li><a><font color="green">
                        Hello ${fullname}!
                        </font></a>
                </li>
                <li>
                    <a href="Logout">Logout</a>
                </li>
                <li>
                    <a href="ViewHistoryController">Shopping History</a>
                </li>
            </c:if>
            <c:if test="${!checkList}">
                <li><a href="login.jsp">Login</a></li>
            </c:if>

            <li>
                <form action="SearchController" method="POST">
                    <input type="text" name="txtSearch">
                    <input name="action" type="submit" value="Search" class="button">
                </form>
            </li>




        </ul>
    </div>
</nav>
</header>