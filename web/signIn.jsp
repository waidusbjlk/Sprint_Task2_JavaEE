<html>
<head>
  <title>SIGN IN PAGE</title>
  <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container mt-5">
  <div class="card">
    <h5 class="card-header">Login Page</h5>
    <div class="card-body">
      Email: <input type="text" name="email" class="form-control" placeholder="insert email" required><br>
      Password: <input type="password" name="password" class="form-control" placeholder="insert password" required><br>
      <button type="submit" class="btn btn-success">Login</button>
    </div>
  </div>
</div>
</body>
</html>