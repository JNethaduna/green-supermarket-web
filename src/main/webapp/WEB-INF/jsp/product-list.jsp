<%@ taglib prefix="c" uri="jakarta.tags.core" %> <%@ taglib prefix="fn"
uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link rel="stylesheet" href="/css/product-list.css" />
  </head>
  <body>
    <jsp:include page="components/header.jsp" />
    <main>
      <c:forEach items="${products}" var="product">
        <a href="#" class="product">
          <img
            src="/images/products/${fn:replace(fn:toLowerCase(product.name), ' ', '')}.jpg"
            alt="${product.name}" />
          <p class="name">${product.name}</p>
          <small class="price">Rs. ${product.price}</small>
        </a>
      </c:forEach>
    </main>
  </body>
</html>
