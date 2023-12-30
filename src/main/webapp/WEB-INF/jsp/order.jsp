<%@ taglib prefix="c" uri="jakarta.tags.core" %> <%@ taglib prefix="fmt"
uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <style>
      body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        background-color: #f4f4f4;
        margin: 0;
      }

      .container {
        width: 50%;
        margin: 20px auto;
        border: 1px solid #dddddd;
        border-radius: 8px;
        overflow: hidden;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        background-color: #fff;
      }

      h1 {
        color: #4caf50;
        text-align: center;
        margin: 15px 0;
        font-size: 24px;
      }

      .order {
        border-bottom: 1px solid #dddddd;
        padding: 20px;
      }

      table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 15px;
      }

      th,
      td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 12px;
      }

      th {
        background-color: #4caf50;
        color: white;
      }

      .inner-table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
      }

      .inner-table th,
      .inner-table td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 10px;
      }

      .order table {
        margin-top: 10px;
        margin-bottom: 10px;
      }

      .order-id {
        text-align: center;
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 15px;
      }
    </style>
  </head>

  <body>
    <div class="container">
      <h1>${order.id}</h1>
      <div class="order">
        <table>
          <tr>
            <th>Order Date</th>
            <td>${order.placementTime}</td>
          </tr>
          <tr>
            <th>Products</th>
            <td colspan="3">
              <table class="inner-table">
                <c:forEach items="${order.orderDetails}" var="orderDetail">
                  <tr>
                    <td>${orderDetail.product.name}</td>
                    <td>${orderDetail.quantity}</td>
                  </tr>
                </c:forEach>
              </table>
            </td>
          </tr>
          <tr>
            <th>Total Amount</th>
            <td colspan="3">
              <fmt:formatNumber
                value="${order.payment.amount}"
                type="currency"
                currencySymbol="LKR" />
            </td>
          </tr>
          <tr>
            <th>Delivery Address</th>
            <td colspan="3">${order.customer.address}</td>
          </tr>
          <tr>
            <th>Contact Number</th>
            <td colspan="3">${order.customer.phone}</td>
          </tr>
        </table>
      </div>
    </div>
  </body>
</html>
