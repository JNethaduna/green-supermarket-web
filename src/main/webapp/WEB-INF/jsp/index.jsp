<%@ taglib prefix="c" uri="jakarta.tags.core" %> <%@ taglib prefix="fn"
uri="jakarta.tags.functions" %> <%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link rel="stylesheet" href="/css/index.css" />
  </head>
  <body>
    <jsp:include page="components/header.jsp" />
    <section id="categories">
      <h2>Categories</h2>
      <ul>
        <a href="/product/list?category=fresh-produce" class="category">
          <li>Fresh Produce</li>
        </a>
        <a href="/product/list?category=dairy-and-eggs" class="category">
          <li>Dairy and Eggs</li>
        </a>
        <a href="/product/list?category=meat-and-poultry" class="category">
          <li>Meat and Poultry</li>
        </a>
        <a href="/product/list?category=bakery" class="category">
          <li>Bakery</li>
        </a>
        <a href="/product/list?category=beverages" class="category">
          <li>Beverages</li>
        </a>
        <a href="/product/list?category=frozen-fresh" class="category">
          <li>Frozen Foods</li>
        </a>
        <a href="/product/list?category=pantry-staples" class="category">
          <li>Pantry Staples</li>
        </a>
        <a href="/product/list?category=snacks" class="category">
          <li>Snacks</li>
        </a>
        <a
          href="/product/list?category=household-and-cleaning"
          class="category">
          <li>Household and Cleaning</li>
        </a>
        <a href="/product/list?category=personal-care" class="category">
          <li>Personal Care</li>
        </a>
      </ul>
    </section>
    <section id="popular">
      <h2>Popular Products</h2>
      <ul>
        <c:forEach items="${products}" var="product">
          <a href="/product/${product.id}" class="product">
            <img
              src="/images/products/${fn:replace(fn:toLowerCase(product.name), ' ', '')}.jpg"
              alt="${product.name}" />
            <p class="name">${product.name}</p>
            <small class="price">
              <fmt:formatNumber
                value="${product.price}"
                type="currency"
                currencySymbol="LKR" />
            </small>
          </a>
        </c:forEach>
      </ul>
    </section>
    <jsp:include page="components/footer.jsp" />
  </body>
</html>
