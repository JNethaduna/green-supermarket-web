<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link rel="stylesheet" href="/css/register.css" />
    <link
      href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
      rel="stylesheet" />
  </head>
  <body>
    <div class="wrapper">
      <h1>Register</h1>
      <form action="/register" method="post">
        <div class="input-box">
          <input name="fName" type="text" placeholder="First Name" />
          <i class="bx bx-user"></i>
        </div>
        <div class="input-box">
          <input name="lName" type="text" placeholder="Last Name" />
          <i class="bx bx-user"></i>
        </div>
        <div class="input-box">
          <input name="email" type="email" placeholder="Email" />
          <i class="bx bx-envelope"></i>
        </div>
        <div class="input-box">
          <input name="password" type="password" placeholder="Password" />
          <i class="bx bx-lock-alt"></i>
        </div>
        <div class="input-box">
          <input name="phone" type="tel" placeholder="Telephone" />
          <i class="bx bx-phone"></i>
        </div>
        <div class="input-box">
          <input name="address" type="text" placeholder="Address" />
          <i class="bx bx-building-house"></i>
        </div>
        <button type="submit" class="btn">Register</button>
        <p class="terms">
          By clicking the above button you agree to our
          <a href="#link">Terms and Conditions</a> and
          <a href="#link2">Privacy Policy</a>.
        </p>
      </form>
      <p class="login">Already have an account? <a href="/login">Login</a></p>
    </div>
  </body>
</html>
