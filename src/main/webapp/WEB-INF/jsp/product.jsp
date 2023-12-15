<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Green Supermarket Web</title>
    <link rel="stylesheet" href="/css/main.css" />
    <link rel="stylesheet" href="/css/product.css" />
  </head>
  <body>
    <jsp:include page="header.jsp" />
    <main>
      <div class="product">
        <div class="product__image">
          <!-- <img src="/images/products/${product.name}" alt="${product.name}" /> -->
        </div>
        <div class="product__info">
          <a
            class="product__category"
            href="/product/list?category=${product.category}">
            ${product.category}
          </a>
          <h1 class="product__name">${product.name}</h1>
          <p class="product__description">${product.description}</p>
          <p class="product__price">Rs.${product.price}</p>
          <form action="/cart" method="post">
            <!-- <input type="hidden" name="id" value="${product.id}" /> -->
            <input type="number" name="quantity" value="1" min="1" />
            <button type="submit">Add to cart</button>
          </form>
        </div>
      </div>
    </main>
  </body>
</html>
