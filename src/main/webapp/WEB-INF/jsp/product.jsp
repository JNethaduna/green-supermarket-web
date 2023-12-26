<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Page</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
  <style>
    :root {
      --primary-color: hsl(130, 45%, 57%);
      --secondary-color: hsl(0, 0%, 100%);
      --tertiary-color: hsl(0, 0%, 92%);
      --text-color: hsl(0, 0%, 6%);
      --white-color: #ffffff;
    }

    body {
      font-family: 'Arial', sans-serif;
      margin: 0;
      padding: 0;
      background-color: var(--secondary-color);
      color: var(--text-color);
    }

    header {
      background-color: var(--primary-color);
      color: var(--secondary-color);
      text-align: center;
      padding: 1em;
    }

    .navigation {
      display: flex;
      justify-content: space-between;
      padding: 1em;
      background-color: var(--primary-color);
      color: var(--secondary-color);
    }

    .logo a {
      text-decoration: none;
      color: var(--secondary-color);
      font-size: 24px;
      font-weight: bold;
    }

    .links a {
      text-decoration: none;
      color: var(--secondary-color);
      margin-left: 20px;
      font-size: 18px;
    }

    .product-section {
      display: flex;
      justify-content: center;
      align-items: flex-start; 
      margin: 20px;
    }

    .product-image img {
      width: 500px;
      height: auto;
      border-radius: 8px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); 
    }

    .product-details {
      max-width: 400px;
      margin-left: 20px;
    }

    .category {
      color: var(--primary-color);
      margin-bottom: 10px;
      font-size: 18px;
    }

    h2 {
      color: var(--primary-color);
    }

    p {
      color: var(--text-color);
      font-size: 16px;
      margin-bottom: 20px;
    }

    .bold-label {
      font-weight: bold;
    }

    .add-to-cart-container {
      display: flex;
      align-items: flex-start;
      margin-top: 10px;
      flex-direction: column; 
    }

    .quantity-label {
      margin-bottom: 5px; 
    }

    .counter {
      width: 150px;
      margin-top: 10px; 
      display: flex;
      align-items: center;
      justify-content: flex-start; 
    }

    .counter input {
      width: 30px;
      border: 0;
      line-height: 30px;
      font-size: 16px;
      text-align: center;
      background: var(--secondary-color); 
      color: var(--text-color); 
      appearance: none;
      outline: 0;
      border-radius: 4px;
    }

    .counter span {
      font-size: 16px;
      padding: 0 10px;
      cursor: pointer;
      color: var(--white-color); 
      user-select: none;
      background: var(--primary-color); 
      border-radius: 2px;
    }

    .add-to-cart-button {
      background-color: var(--primary-color);
      color: var(--secondary-color);
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
      height: 40px;
      margin-top: 10px; 
    }

    .add-to-cart-button:hover {
      background-color: #45a049;
    }
  </style>
</head>

<body>
  <header>
    <div class="navigation">
      <div class="logo">
        <a href="/">Green</a>
      </div>
      <div class="links">
        <a href="/user/cart">Cart</a>
        <a href="/login">Login</a>
        <a href="/user/feedback">Feedback</a>
      </div>
    </div>
  </header>
  <section class="product-section">
    <div class="product-image">
      <img src="almondmilk.jpg" alt="Product Image">
    </div>

    <div class="product-details">
      <div class="category">Dairy and Eggs</div>
      <h2>Almond Milk</h2>
      <p class="bold-label">Description:</p>
      <p>A plant-based milk that is a good alternative to dairy milk for people with lactose intolerance.</p>
      <p class="bold-label">Price:</p>
      <p>LKR 400</p>
      <p class="quantity-label bold-label">Quantity:</p>
        <div class="counter">
          <span class="down" onClick='decreaseCount(event, this)'>-</span>
          <input class="product-qty" type="text" name="product-qty" value="1">
          <span class="up" onClick='increaseCount(event, this)'>+</span>
        </div>
      <div class="add-to-cart-container">
        <button class="add-to-cart-button">Add to Cart</button>
      </div>
    </div>
  </section>

  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
  <script>
    function increaseCount(a, b) {
      var input = b.previousElementSibling;
      var value = parseInt(input.value, 10);
      value = isNaN(value) ? 0 : value;
      value++;
      input.value = value;
    }

    function decreaseCount(a, b) {
      var input = b.nextElementSibling;
      var value = parseInt(input.value, 10);
      if (value > 1) {
        value = isNaN(value) ? 0 : value;
        value--;
        input.value = value;
      }
    }
  </script>
</body>

</html>
