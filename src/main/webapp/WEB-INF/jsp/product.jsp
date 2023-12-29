<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <style>
      .logo a {
        text-decoration: none;
        color: var(--secondary-color);
        font-size: 24px;
        font-weight: bold;
      }

      .links a {
        text-decoration: none;
        color: var(--secondary-color);
        margin-left: 20px;
        font-size: 18px;
      }

      .product-section {
        display: flex;
        justify-content: center;
        align-items: flex-start;
        margin: 20px;
      }

      .product-image img {
        width: 500px;
        height: auto;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      }

      .product-details {
        max-width: 400px;
        margin-left: 20px;
      }

      .category {
        color: var(--primary-color);
        margin-bottom: 10px;
        font-size: 18px;
      }

      h2 {
        color: var(--primary-color);
      }

      p {
        color: var(--text-color);
        font-size: 16px;
        margin-bottom: 20px;
      }

      .bold-label {
        font-weight: bold;
      }

      .add-to-cart-container {
        display: flex;
        align-items: flex-start;
        margin-top: 10px;
        flex-direction: column;
      }

      .quantity-label {
        margin-bottom: 5px;
      }

      .counter {
        width: 150px;
        margin-top: 10px;
        display: flex;
        align-items: center;
        justify-content: flex-start;
      }

      .counter input {
        width: 30px;
        border: 0;
        line-height: 30px;
        font-size: 16px;
        text-align: center;
        background: var(--secondary-color);
        color: var(--text-color);
        appearance: none;
        outline: 0;
        border-radius: 4px;
      }

      .counter span {
        font-size: 16px;
        padding: 0 10px;
        cursor: pointer;
        color: var(--white-color);
        user-select: none;
        background: var(--primary-color);
        border-radius: 2px;
      }

      .add-to-cart-button {
        background-color: var(--primary-color);
        color: var(--secondary-color);
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        height: 40px;
        margin-top: 10px;
      }

      .add-to-cart-button:hover {
        background-color: #45a049;
      }
    </style>
  </head>

  <body>
    <jsp:include page="components/header.jsp" />
    <section class="product-section">
      <div class="product-image">
        <img
          src="/images/products/${fn:replace(fn:toLowerCase(product.name), ' ', '')}.jpg"
          alt="${product.name}" />
      </div>
      <div class="product-details">
        <div class="category">${product.category}</div>
        <h2>${product.name}</h2>
        <p class="bold-label">Description:</p>
        <p>${product.description}</p>
        <p class="bold-label">Price:</p>
        <p>LKR ${product.price}</p>
        <p class="quantity-label bold-label">Quantity:</p>
        <form action="/user/cart/add" method="post">
          <input type="hidden" name="id" value="${product.id}" />
          <div class="counter">
            <span class="down" onClick="decreaseCount(event, this)">-</span>
            <input class="product-qty" type="text" name="quantity" value="1" />
            <span class="up" onClick="increaseCount(event, this)">+</span>
          </div>
          <div class="add-to-cart-container">
            <button type="submit" class="add-to-cart-button">
              Add to Cart
            </button>
          </div>
        </form>
      </div>
    </section>
    <jsp:include page="components/footer.jsp" />

    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
      function increaseCount(a, b) {
        var input = b.previousElementSibling;
        var value = parseInt(input.value, 10);
        value = isNaN(value) ? 0 : value;
        value++;
        input.value = value;
      }

      function decreaseCount(a, b) {
        var input = b.nextElementSibling;
        var value = parseInt(input.value, 10);
        if (value > 1) {
          value = isNaN(value) ? 0 : value;
          value--;
          input.value = value;
        }
      }

      $(document).ready(function () {
        $('form').submit(function (event) {
          event.preventDefault();
          var productId = $(this).find("input[name='id']").val();
          var quantity = $(this).find("input[name='quantity']").val();
          $.ajax({
            url: '/user/cart/add',
            type: 'POST',
            data: {
              id: productId,
              quantity: quantity,
            },
            success: function (response) {
              alert('Product added to cart successfully!');
            },
            error: function (error) {
              alert('Error adding product to cart! Please try again.');
            },
          });
        });
      });
    </script>
  </body>
</html>
