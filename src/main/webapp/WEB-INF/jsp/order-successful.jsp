<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <style>
      body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f4;
        text-align: center;
        margin: 0;
        padding: 0;
      }

      .container {
        max-width: 600px;
        margin: 50px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      }

      h1 {
        color: #4caf50;
      }

      p {
        color: #555;
      }

      .confirmation-icon {
        color: #4caf50;
        font-size: 64px;
        margin-bottom: 20px;
      }

      .button {
        display: inline-block;
        background-color: #4caf50;
        color: #fff;
        margin-top: 10px;
        padding: 10px 20px;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s;
      }

      .button:hover {
        background-color: #45a049;
      }
    </style>
  </head>

  <body>
    <jsp:include page="components/header.jsp" />
    <div class="container">
      <div class="confirmation-icon">&#10003;</div>
      <h1>Order Placed Successfully!</h1>
      <p>
        Thank you for choosing Green Supermarket. Your order has been received
        and is being processed.
      </p>
      <p>
        An email confirmation / SMS Notification has been sent to your
        registered email address or device.
      </p>
      <p>Your order details:</p>
      <!-- Include order details here, such as order number, items, total, etc. -->

      <p>Estimated delivery date: ${delivery}</p>

      <p>For any inquiries, please contact our customer support.</p>

      <a href="/" class="button">Continue Shopping</a>
    </div>
    <jsp:include page="components/footer.jsp" />
  </body>
</html>
