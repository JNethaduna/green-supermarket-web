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
        <form class="cart-item">
          <div>${item.product.name}</div>
          <div>Rs. ${item.product.price}</div>
          <div>${item.quantity}</div>
          <div>Rs. ${item.product.price * item.quantity}</div>
          <input type="hidden" name="id" value="${item.product.id}" />
          <button type="submit" class="btn-remove">
            <i class="bx bx-trash"></i>
          </button>
        </form>
      </c:forEach>
      <a href="/user/checkout">Checkout</a>
    </main>
    <jsp:include page="components/footer.jsp" />
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
      $(document).ready(function () {
        $('form').submit(function (event) {
          event.preventDefault();
          var productId = $(this).find("input[name='id']").val();
          $.ajax({
            url: '/user/cart/remove',
            type: 'POST',
            data: {
              id: productId,
            },
            success: function (response) {
              location.reload();
            },
            error: function (error) {
              alert('Error removing product from cart! Please try again.');
            },
          });
        });
      });
    </script>
  </body>
</html>
