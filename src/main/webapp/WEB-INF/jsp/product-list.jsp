<%@page import="java.util.List"%> <%@page
import="com.green.supermarketwebapp.Models.Product"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link rel="stylesheet" href="/css/product-list.css" />
  </head>
  <body>
    <jsp:include page="components/header.jsp" />
    <main>
      <% List<Product> products = (List<Product>) request.getAttribute("products");
          for(Product prod : products) { 
      %>
      <a href="#" class="product">
        <img src="/images/products/<%= prod.getName().toLowerCase().replaceAll("\\s","") %>.jpg" alt="<%= prod.getName() %>" />
        <p class="name"><%= prod.getName() %></p>
        <small class="price">Rs. <%= prod.getPrice() %></small>
      </a>
      <% } %>
    </main>
  </body>
</html>
