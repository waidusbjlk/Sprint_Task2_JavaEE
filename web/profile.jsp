<%@ page import="kz.bitlab.servlets.db.Users" %>
<head>
    <title>SHOP LAPTOP</title>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
    <div class="container mt-3">
        <div class="row">
            <div class="col-12 mx-auto">
                <h1>Hello <%=currentUser.getFullName()%></h1>
            </div>
        </div>
    </div>
</body>
</html>