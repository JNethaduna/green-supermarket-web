<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Green Supermarket</title>
    <style>
      body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin: 0;
        display: flex;
        align-items: center;
        justify-content: center;
        min-height: 100vh;
        background-color: #f4f4f4;
      }

      form {
        max-width: 400px;
        width: 100%;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      }

      h2 {
        text-align: center;
        color: #333;
      }

      label {
        display: block;
        margin-bottom: 8px;
        color: #555;
      }

      input,
      textarea,
      select {
        width: 100%;
        padding: 10px;
        margin-bottom: 16px;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 4px;
      }

      input[type='submit'] {
        background-color: #4caf50;
        color: white;
        cursor: pointer;
        border: none;
      }

      input[type='submit']:hover {
        background-color: #45a049;
      }
    </style>
  </head>
  <body>
    <jsp:include page="components/header-manager.jsp" />
    <form action="/manage/product/add" method="post">
      <h2>Add Product</h2>

      <label for="productName">Product Name:</label>
      <input type="text" id="productName" name="name" required />

      <label for="productDescription">Product Description:</label>
      <textarea
        id="productDescription"
        name="description"
        rows="4"
        required></textarea>

      <label for="price">Price:</label>
      <input
        type="number"
        id="price"
        name="price"
        min="0"
        step="0.01"
        required />

      <label for="category">Category:</label>
      <input type="text" id="category" name="category" required />

      <label for="stock">Stock:</label>
      <input type="number" id="stock" name="stock" min="0" required />

      <input type="submit" value="Add Product" />
    </form>
  </body>
</html>
