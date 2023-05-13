<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.servlets.db.Items" %>
<%@ page import="kz.bitlab.servlets.db.News" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SHOP LAPTOP</title>
    <%@include file="head.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-12">
            <%
                ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");
                if(news!=null){
                    for(News n:news){
            %>
            <div>
                <h3><%=n.getTitle()%></h3>
                <p><%=n.getContent()%></p>
            </div>
            <%}
            }
            %>
            <div>

            </div>
        </div>
    </div>
</div>

</body>
</html>