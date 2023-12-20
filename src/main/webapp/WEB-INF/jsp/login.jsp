<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link rel="stylesheet" href="/css/login.css" />
    <link
      href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
      rel="stylesheet" />
  </head>
  <body>
    <div class="wrapper">
      <h1>Login</h1>
      <form action="/login" method="post">
        <div class="input-box">
          <input name="email" type="text" placeholder="Email" />
          <i class="bx bx-envelope"></i>
        </div>
        <div class="input-box">
          <input name="password" type="password" placeholder="Password" />
          <i class="bx bx-lock-alt"></i>
        </div>
        <button type="submit" class="btn">Login</button>
      </form>
      <p class="register">
        Don't have an account? <a href="/register">Register</a>
      </p>
    </div>
  </body>
</html>
