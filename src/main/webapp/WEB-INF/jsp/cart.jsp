<%@page import="java.util.List"%> <%@page
import="com.green.supermarketwebapp.Models.Cart"%>
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
      <% 
        List<Cart> cart = (List<Cart>) request.getAttribute("cart");
        for (Cart item : cart) {
      %>
        <div class="cart-item">
          <input type="checkbox" name="include" />
          <div><%= item.getProduct().getName() %></div>
          <div>Rs. <%= item.getProduct().getPrice() %></div>
          <div><%= item.getQuantity() %></div>
          <div>Rs. <%= item.getProduct().getPrice() * item.getQuantity() %></div>
          <button class="btn-remove">
            <i class="bx bx-trash"></i>
          </button>
        </div>
      <% } %>
    </main>
  </body>
</html>
