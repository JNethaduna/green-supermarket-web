<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link rel="stylesheet" href="/css/product.css" />
  </head>
  <body>
    <jsp:include page="components/header.jsp" />
    <main>
      <div class="image">
        <img
          src="/images/products/${product.name.toLowerCase().replaceAll('\\s','')}.jpg"
          alt="${product.name}" />
      </div>
      <div class="info-wrapper">
        <div class="info">
          <a
            class="category"
            href="/product/list?category=${product.category.toLowerCase().replaceAll('\\s', '-')}">
            ${product.category}
          </a>
          <h1 class="name">${product.name}</h1>
          <p class="description">${product.description}</p>
          <p class="price">Rs. ${product.price}</p>
          <form action="/user/cart/add" method="post">
            <input type="hidden" name="id" value="${product.id}" />
            <input type="text" name="quantity" value="1" />
            <button type="submit">Add to cart</button>
          </form>
        </div>
      </div>
    </main>
  </body>
</html>
