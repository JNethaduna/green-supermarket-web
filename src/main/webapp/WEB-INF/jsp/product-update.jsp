<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Product Details</title>
    <style>
        body {
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
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }
        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
            color: #555;
        }
        input, textarea {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }
    </style>
</head>
<body>

<h1>Update Product Details</h1>

<form id="productForm" action="update_product.php" method="post">
    <label for="ID">Product ID:</label>
    <input type="text" id="ID" name="ID" required>

    <label for="Name">Name:</label>
    <input type="text" id="Name" name="Name" required>

    <label for="Description">Description:</label>
    <textarea id="Description" name="Description" rows="4" required></textarea>

    <label for="Price">Price:</label>
    <input type="number" id="Price" name="Price" step="0.01" required>

    <label for="Category">Category:</label>
    <input type="text" id="Category" name="Category" required>

    <label for="Stock">Stock:</label>
    <input type="number" id="Stock" name="Stock" required>

    <button type="submit">Update Details</button>
</form>

</body>
</html>
