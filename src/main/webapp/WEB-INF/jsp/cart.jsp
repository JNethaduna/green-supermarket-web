<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Online Supermarket Checkout</title>
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
        align-content: center;
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

        width: 90%;
        max-width: 200px;

        margin: 0;

        display: block;
        margin-top: 20px;

        transition: background-color 0.3s ease;
      }
      .trash-button {
        background-color: var(--primary-color);
        color: var(--secondary-color);
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        align-content: center;
        cursor: pointer;
        font-size: 15px;

        max-width: 200px;

        margin: 0;

        display: block;
        transition: background-color 0.3s ease;
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
        <h2>Items in Cart</h2>
        <div class="items-section">
          <table>
            <tr>
              <th></th>
              <th>Name</th>
              <th>Unit Price</th>
              <th>Quantity</th>
              <th>Price</th>
              <th><!--Trash Button--></th>
            </tr>
            <tr>
              <td class="product-image">
                <img src="almondmilk.jpg" alt="Almond Milk" />
              </td>
              <td>Almond Milk</td>
              <td>$10.00</td>
              <td>2</td>
              <td>$20.00</td>
              <td>
                <button type="submit" class="trash-button">
                  <i class="bx bx-trash"></i>
                </button>
              </td>
            </tr>
            <tr>
              <td class="product-image">
                <img src="aluminiumfoil.jpg" alt="Aluminium Foil" />
              </td>
              <td>Aluminium Foil</td>
              <td>$20.00</td>
              <td>2</td>
              <td>$40.00</td>
              <td>
                <button type="submit" class="trash-button">
                  <i class="bx bx-trash"></i>
                </button>
              </td>
            </tr>
            <tr>
              <td class="product-image"><img src="apple.jpg" alt="Apple" /></td>
              <td>Apple</td>
              <td>$20.00</td>
              <td>10</td>
              <td>$200.00</td>
              <td>
                <button type="submit" class="trash-button">
                  <i class="bx bx-trash"></i>
                </button>
              </td>
            </tr>
            <tr>
              <td class="product-image">
                <img src="applejuice.jpg" alt="Apple" />
              </td>
              <td>Apple Juice</td>
              <td>$5.00</td>
              <td>3</td>
              <td>$15.00</td>
              <td>
                <button type="submit" class="trash-button">
                  <i class="bx bx-trash"></i>
                </button>
              </td>
            </tr>
          </table>
        </div>
      </div>

      <div class="right-column">
        <h2>Amount</h2>
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
  </body>
</html>
