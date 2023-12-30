<%@ taglib prefix="c" uri="jakarta.tags.core" %> <%@ taglib prefix="fn"
uri="jakarta.tags.functions" %> <%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <style>
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

      th,
      td {
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
            <p>
              <fmt:formatNumber
                value="${subtotal}"
                type="currency"
                currencySymbol="LKR" />
            </p>
            <p>
              <fmt:formatNumber
                value="200"
                type="currency"
                currencySymbol="LKR" />
            </p>
            <p>
              <fmt:formatNumber
                value="${(subtotal * 5)/100}"
                type="currency"
                currencySymbol="LKR" />
            </p>
            <p>
              <fmt:formatNumber
                value="${subtotal + 200 + (subtotal * 5)/100}"
                type="currency"
                currencySymbol="LKR" />
            </p>
          </div>
        </div>
        <h2>Items Purchased</h2>
        <div class="items-section">
          <table>
            <c:forEach items="${cartItems}" var="item">
              <tr>
                <td class="product-image">
                  <img
                    src="/images/products/${fn:replace(fn:toLowerCase(item.product.name), ' ', '')}.jpg"
                    alt="${item.product.name}" />
                </td>
                <td>${item.product.name}</td>
                <td>${item.quantity}</td>
                <td>
                  <fmt:formatNumber
                    value="${item.product.price}"
                    type="currency"
                    currencySymbol="LKR" />
                </td>
              </tr>
            </c:forEach>
          </table>
        </div>
      </div>

      <div class="right-column">
        <div class="address-section">
          <h2>Shipping Address</h2>
          <p>${customer.firstName} ${customer.lastName}</p>
          <p>${customer.address}</p>
          <p>Email: ${customer.email}</p>
        </div>

        <div class="shipping-section">
          <h2>Shipping Method</h2>
          <p>Standard Shipping</p>
          <p>Expected Delivery: ${delivery}</p>
        </div>
        <form
          action="/payment/paypal/start"
          method="post"
          class="paypal-button-container">
          <button type="submit" class="paypal-button">Pay with Paypal</button>
        </form>
      </div>
    </section>
    <jsp:include page="components/footer.jsp" />
  </body>
</html>
