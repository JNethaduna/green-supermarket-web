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
        <img src="/images/products/apple.jpg" alt="Apple" />
      </div>
      <div class="info-wrapper">
        <div class="info">
          <a class="category" href="/product/list?category=fresh-produce">
            Fresh Produce
          </a>
          <h1 class="name">Apple</h1>
          <p class="description">Apples are cool</p>
          <p class="price">Rs.50.00</p>
          <form action="/cart" method="post">
            <input type="text" name="quantity" value="1" />
            <button type="submit">Add to cart</button>
          </form>
        </div>
      </div>
    </main>
  </body>
</html>
