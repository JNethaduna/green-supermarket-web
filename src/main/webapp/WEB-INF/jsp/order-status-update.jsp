<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Order Status</title>
    <style>
        :root {
            --primary-color: hsl(130, 45%, 57%);
            --secondary-color: hsl(0, 0%, 100%);
            --tertiary-color: hsl(0, 0%, 92%);
        }

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

        input, select {
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

    <div class="container">
        <h2>Update Order Status</h2>

        <form action="update_status.php" method="post">
            <label for="orderNumber">Order Number:</label>
            <input type="text" id="orderNumber" name="orderNumber" required>

            <label for="newStatus">New Status:</label>
            <select id="newStatus" name="newStatus" required>
                <option value="processing">Processing</option>
                <option value="shipped">Shipped</option>
                <option value="delivered">Delivered</option>
            </select>

            <button type="submit">Update Status</button>
        </form>
    </div>

</body>
</html>
