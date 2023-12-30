<%@ taglib prefix="c" uri="jakarta.tags.core" %> <%@ taglib prefix="fmt"
uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <style>
      main {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        min-height: 100vh;
        background-color: #f4f4f4;
      }

      section {
        margin-top: 20px;
        text-align: left;
        background-color: white;
        border-radius: 8px;
        box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.1);
        padding: 20px;
        width: 80%;
        max-width: 600px;
      }

      h2 {
        color: #4caf50;
      }

      p {
        margin: 10px 0;
      }

      table {
        width: 75%;
        border-collapse: collapse;
        margin-top: 20px;
      }

      table,
      th,
      td {
        border: 1px solid #ddd;
      }

      td a {
        color: #4caf50;
        text-decoration: none;
      }

      th,
      td {
        padding: 10px;
        text-align: center;
      }

      th {
        background-color: #4caf50;
        color: white;
      }
    </style>
  </head>
  <body>
    <jsp:include page="components/header.jsp" />
    <main>
      <section>
        <h2>Welcome ${customer.firstName} ${customer.lastName}!</h2>

        <p>
          <strong>Address:</strong>
          <span id="customerAddress">${customer.address}</span>
        </p>
        <p>
          <strong>Email:</strong>
          <span id="customerEmail">${customer.email}</span>
        </p>
        <p>
          <strong>Phone Number:</strong>
          <span id="customerPhone">${customer.phone}</span>
        </p>

        <h3>Your Orders:</h3>

        <table>
          <thead>
            <tr>
              <th>Order ID</th>
              <th>Total Price</th>
            </tr>
          </thead>
          <tbody id="orderTableBody">
            <c:forEach items="${orders}" var="order">
              <tr>
                <td>
                  <a href="/user/order/${order.id}">${order.id}</a>
                </td>
                <td>
                  <fmt:formatNumber
                    value="${order.payment.amount}"
                    type="currency"
                    currencySymbol="LKR" />
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </section>
    </main>

    <jsp:include page="components/footer.jsp" />
  </body>
</html>
