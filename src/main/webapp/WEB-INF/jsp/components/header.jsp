<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<header>
  <div class="logo">
    <a href="/">Green</a>
  </div>
  <div class="links">
    <a href="/user/feedback">Feedback</a>
    <a href="/user/cart">Cart</a>
    <a href="/user/profile">Profile</a>
    <c:choose>
      <c:when test="${isLoggedIn}">
        <a href="/logout">Logout</a>
      </c:when>
      <c:otherwise>
        <a href="/login">Login</a>
      </c:otherwise>
    </c:choose>
  </div>
</header>
