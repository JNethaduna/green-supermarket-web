<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link rel="stylesheet" href="/css/checkout.css" />
  </head>
  <body>
    <main>
      <div class="checkout">
        <h1>Checkout</h1>
        <hr />
        <div class="delivery">
          <h2>Delivery</h2>
          <div class="address">
            <div>Name</div>
            <div>
              Lorem ipsum, dolor sit amet consectetur adipisicing elit. Iure
              repudiandae numquam cum corrupti magni dignissimos quas veniam
              delectus commodi sint, nostrum modi ipsa nobis dolorem dolorum
              voluptatibus vel accusamus! Officiis.
            </div>
          </div>
        </div>
        <hr />
        <div class="payment">
          <h2>Payment</h2>
          <button class="paypal">Pay with PayPal</button>
        </div>
      </div>
      <div class="items">
        <div class="item">
          <div>Product Name</div>
          <div>$2.99</div>
          <div>5</div>
          <div>$14.95</div>
        </div>
        <div class="item">
          <div>Product Name</div>
          <div>$2.99</div>
          <div>5</div>
          <div>$14.95</div>
        </div>
        <div class="item">
          <div>Product Name</div>
          <div>$2.99</div>
          <div>5</div>
          <div>$14.95</div>
        </div>
        <div class="item">
          <div>Product Name</div>
          <div>$2.99</div>
          <div>5</div>
          <div>$14.95</div>
        </div>
        <hr />
        <div class="price">
          <div>
            <div>Subtotal:</div>
            <div>Tax:</div>
            <div>Total:</div>
          </div>
          <div>
            <div class="number"><span>$</span>59.80</div>
            <div class="number"><span>$</span>3.59</div>
            <div class="number"><span>$</span>63.27</div>
          </div>
        </div>
      </div>
    </main>
  </body>
</html>
