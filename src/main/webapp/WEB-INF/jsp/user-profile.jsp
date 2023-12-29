<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile - Green Supermarket</title>
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
            color: #4CAF50;
        }

        p {
            margin: 10px 0;
        }

        table {
            width: 75%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>

    <section>
        <h2>Welcome Adeesha!</h2>

        <p><strong>Address:</strong> <span id="customerAddress">[Customer Address]</span></p>
        <p><strong>Email:</strong> <span id="customerEmail">[Customer Email]</span></p>
        <p><strong>Phone Number:</strong> <span id="customerPhone">[Customer Phone Number]</span></p>

        <h3>Your Orders:</h3>

        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Total Price</th>
                </tr>
            </thead>
            <tbody id="orderTableBody">
            </tbody>
        </table>
    </section>

    <script>
        var userInfo = {
            address: '123 Green Street, Cityville',
            email: 'Adeesha@Methamail.com',
            phoneNo: '555-1234'
        };

        var orders = [
            { id: 1, totalPrice: 25.99 },
            { id: 2, totalPrice: 10.50 },
        ];

        document.getElementById('customerAddress').textContent = userInfo.address;
        document.getElementById('customerEmail').textContent = userInfo.email;
        document.getElementById('customerPhone').textContent = userInfo.phoneNo;

        var tableBody = document.getElementById('orderTableBody');

        orders.forEach(function(order) {
            var row = tableBody.insertRow();
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);

            cell1.textContent = order.id;
            cell2.textContent = '$' + order.totalPrice.toFixed(2);
        });
    </script>

</body>
</html>
