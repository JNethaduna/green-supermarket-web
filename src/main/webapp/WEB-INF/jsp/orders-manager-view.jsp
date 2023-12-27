<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Orders - GREEN Supermarket</title>
    <style>
        body, h1, h2, h3, p, div, table, th, td {
            margin: 0;
            padding: 0;
        }

        body {
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
            color: #4CAF50;
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

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        .inner-table {
            width: 100%;
            border-collapse: collapse;
        }

        .inner-table th, .inner-table td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        td, th {
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
    <div class="container">
        <h1>Orders</h1>
        <div class="order">
            <div class="order-id">Order ID: 123456</div>
            <table>
                <tr>
                    <th>Order Date</th>
                    <td>2023-12-27</td>
                </tr>
                <tr>
                    <th>Customer Name</th>
                    <td>Menura Dolage</td>
                </tr>
                <tr>
                    <th>Products</th>
                    <td colspan="3">
                        <table class="inner-table">
                            <tr>
                                <td>Aluminium Foil</td>
                                <td>2</td>
                            </tr>
                            <tr>
                                <td>Apple</td>
                                <td>1</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <th>Total Amount</th>
                    <td colspan="3">LKR 1,060</td>
                </tr>
                <tr>
                    <th>Delivery Address</th>
                    <td colspan="3">123 Pott Street, Whoville</td>
                </tr>
                <tr>
                    <th>Contact Number</th>
                    <td colspan="3">(123) 456-7890</td>
                </tr>
            </table>
        </div>
        <div class="order">
            <div class="order-id">Order ID: 789012</div>
            <table>
                <tr>
                    <th>Order Date</th>
                    <td>2023-12-28</td>
                </tr>
                <tr>
                    <th>Customer Name</th>
                    <td>Adeesha Nethaduna</td>
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
        <div class="order">
            <div class="order-id">Order ID: 345678</div>
            <table>
                <tr>
                    <th>Order Date</th>
                    <td>2023-12-29</td>
                </tr>
                <tr>
                    <th>Customer Name</th>
                    <td>Meth Gunawardhana</td>
                </tr>
                <tr>
                    <th>Products</th>
                    <td colspan="3">
                        <table class="inner-table">
                            <tr>
                                <td>Egg</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td>Toothpaste</td>
                                <td>1</td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <th>Total Amount</th>
                    <td colspan="3">LKR 350</td>
                </tr>
                <tr>
                    <th>Delivery Address</th>
                    <td colspan="3">789 Pine Lane, Methtown</td>
                </tr>
                <tr>
                    <th>Contact Number</th>
                    <td colspan="3">(555) 123-4567</td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>
