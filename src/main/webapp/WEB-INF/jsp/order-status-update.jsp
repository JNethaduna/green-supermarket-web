<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <style>
      body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: var(--tertiary-color);
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
      }

      .container {
        background-color: var(--secondary-color);
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        padding: 20px;
        border-radius: 8px;
        width: 100%;
        max-width: 400px;
        text-align: center;
      }

      h2 {
        color: var(--primary-color);
      }

      form {
        margin-top: 20px;
      }

      label {
        display: block;
        margin-bottom: 8px;
        color: #555;
      }

      input,
      select {
        width: 100%;
        padding: 10px;
        margin-bottom: 16px;
        box-sizing: border-box;
        border: 1px solid #ddd;
        border-radius: 4px;
      }

      button {
        background-color: var(--primary-color);
        color: var(--secondary-color);
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
      }

      button:hover {
        background-color: hsl(130, 45%, 47%);
      }
    </style>
  </head>
  <body>
    <jsp:include page="components/header-manager.jsp" />
    <div class="container">
      <h2>Update Order Status</h2>
      <form>
        <label for="orderNumber">Order ID:</label>
        <input type="text" id="orderNumber" name="id" required />

        <label for="newStatus">New Status:</label>
        <select id="newStatus" name="status" required>
          <option value="processing">Processing</option>
          <option value="shipped">Shipped</option>
          <option value="delivered">Delivered</option>
        </select>
        <button type="submit">Update Status</button>
      </form>
    </div>
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
