<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order [ID]</title>
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
            color: #4CAF50;
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

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 12px;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        .inner-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        .inner-table th, .inner-table td {
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
        <h1>Order [ID]</h1>
        <div class="order">
            <table>
                <tr>
                    <th>Order Date</th>
                    <td>2023-12-28</td>
                </tr>
                <tr>
                    <th>Products</th>
                    <td colspan="3">
                        <table class="inner-table">
                            <tr>
                                <td>Banana</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td>Cucumber</td>
                                <td>4</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <th>Total Amount</th>
                    <td colspan="3">LKR 3,079</td>
                </tr>
                <tr>
                    <th>Delivery Address</th>
                    <td colspan="3">456 Ilk Street, Nethaville</td>
                </tr>
                <tr>
                    <th>Contact Number</th>
                    <td colspan="3">(987) 654-3210</td>
                </tr>
            </table>
        </div>
    </div>
</body>

</html>
