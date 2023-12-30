<%@ taglib prefix="c" uri="jakarta.tags.core" %> <%@ taglib prefix="fn"
uri="jakarta.tags.functions" %> <%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <style>
      body,
      h1,
      h2,
      h3,
      p,
      div,
      table,
      th,
      td {
        margin: 0;
        padding: 0;
      }

      main {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        background-color: #f4f4f4;
      }

      .container {
        width: 50%;
        margin: 20px auto;
        border: 1px solid #dddddd;
        border-radius: 8px;
        overflow: hidden;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      }

      h1 {
        color: #4caf50;
        text-align: center;
        margin: 10px 0;
      }

      .order {
        border-bottom: 1px solid #dddddd;
        padding: 10px;
      }

      table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 10px;
      }

      th,
      td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
      }

      th {
        background-color: #4caf50;
        color: white;
      }

      .inner-table {
        width: 100%;
        border-collapse: collapse;
      }

      .inner-table th,
      .inner-table td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
      }

      td,
      th {
        padding: 5px;
      }

      .order table {
        margin-top: 5px;
        margin-bottom: 5px;
      }

      .order-id {
        text-align: center;
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 10px;
      }
    </style>
  </head>
  <body>
    <jsp:include page="components/header-manager.jsp" />
    <main>
      <div class="container">
        <h1>Orders</h1>
        <c:forEach items="${orders}" var="order">
          <div class="order">
            <div class="order-id">${order.id}</div>
            <table>
              <tr>
                <th>Order Date</th>
                <td>${order.placementTime}</td>
              </tr>
              <tr>
                <th>Customer Name</th>
                <td>${order.customer.firstName} ${order.customer.lastName}</td>
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
        </c:forEach>
      </div>
    </main>
  </body>
</html>
