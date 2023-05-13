<%@ page import="kz.bitlab.servlets.db.Users" %>
<%
    Users currentUser = (Users) session.getAttribute("currentUser");
%>
<div class="container">
    <nav class="navbar navbar-expand-lg  bg-success navbar-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">BITLAB SHOP</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                </ul>
                <ul class="navbar-nav d-flex">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Top Sales</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">New Sales</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">By Category</a>
                    </li>
                    <%
                        if(currentUser!=null){
                    %>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/AddItem">AddItem</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/AddNews">AddNews</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/News">News</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            <%=currentUser.getFullName()%>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="/profile">Profile</a></li>
                            <li><a class="dropdown-item" href="#">Setting</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="/logout">Logout</a></li>
                        </ul>
                    </li>
                    <%
                    }else{
                    %>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/login">Sign in</a>
                    </li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>
    </nav>
</div>