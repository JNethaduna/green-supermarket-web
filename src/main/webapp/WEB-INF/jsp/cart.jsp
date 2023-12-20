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
      <div class="cart-item">
        <input type="checkbox" name="include" />
        <div>Product Name</div>
        <div>$2.99</div>
        <div>5</div>
        <div>$14.95</div>
        <button class="btn-remove">
          <i class="bx bx-trash"></i>
        </button>
      </div>
      <div class="cart-item">
        <input type="checkbox" name="include" />
        <div>Product Name</div>
        <div>$22.99</div>
        <div>55</div>
        <div>$147.95</div>
        <button class="btn-remove">
          <i class="bx bx-trash"></i>
        </button>
      </div>
      <div class="cart-item">
        <input type="checkbox" name="include" />
        <div>Product Name</div>
        <div>$222.99</div>
        <div>5</div>
        <div>$14.95</div>
        <button class="btn-remove">
          <i class="bx bx-trash"></i>
        </button>
      </div>
    </main>
  </body>
</html>
