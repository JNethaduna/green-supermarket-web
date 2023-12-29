<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<header>
  <div class="logo">
    <a href="/">Green</a>
  </div>
  <div class="links">
    <a href="/manage/order/list">View Orders</a>
    <a href="/manage/order/update">Update Order Status</a>
    <a href="/manage/product/add">Add Product</a>
    <a href="/manage/product/update">Update Product</a>
    <a href="/manage/feedback/list">View Feedback</a>
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
