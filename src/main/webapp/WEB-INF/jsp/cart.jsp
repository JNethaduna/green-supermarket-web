<%@ taglib prefix="c" uri="jakarta.tags.core" %> <%@ taglib prefix="fn"
uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link
      href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
      rel="stylesheet" />
    <style>
      body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: var(--tertiary-color);
        margin: 0;
        padding: 0;
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
    <jsp:include page="components/header.jsp" />
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
            <c:forEach items="${cart}" var="item">
              <tr>
                <td class="product-image">
                  <img src="almondmilk.jpg" alt="Almond Milk" />
                </td>
                <td>${item.product.name}</td>
                <td>LKR ${item.product.price}</td>
                <td>${item.quantity}</td>
                <td>LKR ${item.product.price * item.quantity}</td>
                <td>
                  <button type="submit" class="trash-button">
                    <i class="bx bx-trash"></i>
                  </button>
                </td>
              </tr>
            </c:forEach>
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
            <c:set var="totalCost" value="0" />
            <c:forEach items="${cart}" var="item">
              <c:set
                var="totalCost"
                value="${totalCost + (item.product.price * item.quantity)}" />
            </c:forEach>
            <p>LKR <c:out value="${totalCost}" /></p>
          </div>
        </div>
        <div class="paypal-button-container">
          <button type="button" class="checkout-button">Checkout</button>
        </div>
      </div>
    </section>
    <jsp:include page="components/footer.jsp" />
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
      $(document).ready(function () {
        $('form').submit(function (event) {
          event.preventDefault();
          var productId = $(this).find("input[name='id']").val();
          $.ajax({
            url: '/user/cart/remove',
            type: 'POST',
            data: {
              id: productId,
            },
            success: function (response) {
              location.reload();
            },
            error: function (error) {
              alert('Error removing product from cart! Please try again.');
            },
          });
        });
      });
    </script>
  </body>
</html>
