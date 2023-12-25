<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Online Supermarket Checkout</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
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

    .left-column,
    .right-column {
      flex: 1;
      background-color: var(--secondary-color);
      border-radius: 8px;
      box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
      padding: 30px;
      margin-bottom: 30px;
      margin-right: 20px;
      height: fit-content;
    }

    h2 {
      color: var(--text-color);
      font-size: 24px;
      margin-bottom: 20px;
    }

    p {
      font-size: 18px;
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

    th, td {
      padding: 10px;
      border: 0px solid var(--tertiary-color);
      text-align: center; 
    }

    .product-image img {
      width: 50px; 
      border-radius: 8px;

      overflow: hidden;
      display: block;
      margin: 0 auto; 
    }

    .paypal-button-container {
      text-align: center; 
    }

    .paypal-button {
      background-color: var(--primary-color);
      color: var(--secondary-color);
      padding: 12px 20px;
   
      border: none;
      border-radius: 4px;

      cursor: pointer;
      font-size: 18px;

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
  <header>
    <h1>Green Supermarket</h1>
  </header>
  <section class="checkout-section">
    <div class="left-column">
      <h2>Total Amount</h2>
      <div class="total-section">
        <div class="total-words">
          <p>Subtotal:</p>
          <p>Shipping:</p>
          <p>Taxes:</p>
          <p>Total:</p>
        </div>
        <div class="total-amounts">
          <p>$50.00</p>
          <p>$5.00</p>
          <p>$4.50</p>
          <p>$59.50</p>
        </div>
      </div>
      <h2>Items Purchased</h2>
      <div class="items-section">
        <table>
          <tr>
            <th>Image</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Price</th>
          </tr>
          <tr>
            <td class="product-image"><img src="almondmilk.jpg" alt="Almond Milk"></td>
            <td>Almond Milk</td>
            <td>2</td>
            <td>$20.00</td>
          </tr>
          <tr>
            <td class="product-image"><img src="aluminiumfoil.jpg" alt="Aluminium Foil"></td>
            <td>Aluminium Foil</td>
            <td>2</td>
            <td>$40.00</td>
          </tr>
        </table>
      </div>
    </div>

    <div class="right-column">
      <div class="address-section">
        <h2>Shipping Address</h2>
        <p>Adeesha Methaduna</p>
        <p>123 Main Street</p>
        <p>City, State, ZIP</p>
        <p>Email: Adeesha@gmail.com</p>
      </div>

      <div class="shipping-section">
        <h2>Shipping Method</h2>
        <p>Standard Shipping</p>
        <p>Expected Delivery: January 1, 2024</p>
      </div>
      <div class="paypal-button-container">
        <button type="button" class="paypal-button">Pay with Paypal</button>
      </div>
    </div>
  </section>
</body>

</html>
