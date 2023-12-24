<%@ taglib prefix="c" uri="jakarta.tags.core" %> <%@ taglib prefix="fn"
uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link rel="stylesheet" href="/css/cart.css" />
    <link
      href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
      rel="stylesheet" />
  </head>
  <body>
    <jsp:include page="components/header.jsp" />
    <main>
      <c:forEach items="${cart}" var="item">
        <div class="cart-item">
          <input type="checkbox" name="include" />
          <div>${item.product.name}</div>
          <div>Rs. ${item.product.price}</div>
          <div>${item.quantity}</div>
          <div>Rs. ${item.product.price * item.quantity}</div>
          <button class="btn-remove">
            <i class="bx bx-trash"></i>
          </button>
        </div>
      </c:forEach>
    </main>
  </body>
</html>
