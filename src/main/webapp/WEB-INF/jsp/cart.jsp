<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link rel="stylesheet" href="/css/cart.css" />
    <link
      href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
      rel="stylesheet" />
    <style>
      :root {
        --primary-color: hsl(130, 45%, 57%);
        --secondary-color: hsl(0, 0%, 100%);
        --tertiary-color: hsl(0, 0%, 92%);
        --text-color: hsl(0, 0%, 6%);
      }

      body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: var(--tertiary-color);
        margin: 0;
        padding: 0;
      }

      header {
        background-color: var(--primary-color);
        color: var(--secondary-color);
        padding: 1em;
        text-align: center;
      }

      .checkout-section {
        display: flex;
        justify-content: space-around;
        max-width: 1400px;
        margin: 20px auto;
      }
      .left-column {
        flex: 50;
        background-color: var(--secondary-color);
        border-radius: 8px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        padding: 30px;
        margin-bottom: 30px;
        margin-left: 140px;
        margin-right: 70px;
        height: fit-content;
      }

      .right-column {
        flex: 20;
        background-color: var(--secondary-color);
        border-radius: 8px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        padding: 30px;
        margin-bottom: 30px;
        margin-right: 140px;
        height: fit-content;
        font-size: 140;
      }

      h2 {
        color: var(--text-color);
        font-size: 24px;
        margin-bottom: 20px;
      }

      p {
        font-size: 15px;
        margin-bottom: 10px;
        color: var(--text-color);
      }

      .items-section {
        margin-top: 20px;
      }

      table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
      }

      th,
      td {
        padding: 10px;
        border: 0px solid var(--tertiary-color);
        text-align: center;
      }

      .product-image img {
        width: 80px;
        border-radius: 8px;

        overflow: hidden;
        display: block;
        margin: 0 auto;
      }

      .paypal-button-container {
        text-align: center;
      }

      .checkout-button {
        background-color: var(--primary-color);
        color: var(--secondary-color);
        padding: 12px 20px;
        border: none;
        border-radius: 4px;

        cursor: pointer;
        font-size: 15px;

        width: 100%;
        max-width: 200px;

        margin: 0;

        display: block;
        margin-top: 20px;

        transition: background-color 0.3s ease;
      }

      .paypal-button:hover {
        background-color: #005aa0;
      }

      .total-section {
        display: flex;
      }

      .total-words {
        width: 100px;
        font-weight: bold;
      }

      .total-words p,
      .total-amounts p {
        margin: 10px 100;
      }
    </style>
  </head>
  <body>
    <jsp:include page="components/header.jsp" />
    <section class="checkout-section">
      <div class="left-column">
        <h2>Items in Cart</h2>
        <div class="items-section">
          <table>
            <tr>
              <th></th>
              <th>Name</th>
              <th>Quantity</th>
              <th>Price</th>
            </tr>
            <c:forEach items="${cart}" var="item">
              <div class="cart-item">
                <input type="checkbox" name="include" />
                <div>${item.product.name}</div>
                <div>Rs. ${item.product.price}</div>
                <div>${item.quantity}</div>
                <div>Rs. ${item.product.price * item.quantity}</div>
              </div>
            </c:forEach>
            <tr>
              <td class="product-image">
                <img src="almondmilk.jpg" alt="Almond Milk" />
              </td>
              <td>${item.product.name}</td>
              <td>${item.quantity}</td>
              <td>Rs. ${item.product.price * item.quantity}</td>
              <td>
                <button class="btn-remove">
                  <i class="bx bx-trash"></i>
                </button>
              </td>
            </tr>
            <tr>
              <td class="product-image">
                <img src="aluminiumfoil.jpg" alt="Aluminium Foil" />
              </td>
              <td>Aluminium Foil</td>
              <td>2</td>
              <td>$40.00</td>
            </tr>
            <tr>
              <td class="product-image"><img src="apple.jpg" alt="Apple" /></td>
              <td>Apple</td>
              <td>10</td>
              <td>$201.00</td>
            </tr>
            <tr>
              <td class="product-image">
                <img src="applejuice.jpg" alt="Apple" />
              </td>
              <td>Apple Juice</td>
              <td>3</td>
              <td>$15.00</td>
            </tr>
          </table>
        </div>
      </div>

      <div class="right-column">
        <h2>Total Amount</h2>
        <div class="total-section">
          <div class="total-words">
            <p>Subtotal:</p>
          </div>
          <div class="total-amounts">
            <p>$50.00</p>
          </div>
        </div>
        <div class="paypal-button-container">
          <button type="button" class="checkout-button">Checkout</button>
        </div>
      </div>
    </section>
    <main></main>
  </body>
</html>
