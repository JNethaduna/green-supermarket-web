<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Green Supermarket - Update Profile</title>
    <style>
      body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
        background-color: #f4f4f4;
      }
      form {
        max-width: 400px;
        width: 100%;
        padding: 20px;
        box-sizing: border-box;
        background-color: #ffffff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      }
      h2 {
        text-align: center;
        color: #333333;
      }
      label {
        display: block;
        margin-bottom: 8px;
        color: #333333;
      }
      input {
        width: 100%;
        padding: 10px;
        margin-bottom: 16px;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 4px;
      }
      button {
        background-color: #4caf50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
      }
      button:hover {
        background-color: #45a049;
      }
    </style>
  </head>
  <body>
    <form action="/user/profile/update" method="post">
      <h2>Update User Profile</h2>

      <label for="firstName">First Name:</label>
      <input type="text" id="firstName" name="fName" required />

      <label for="lastName">Last Name:</label>
      <input type="text" id="lastName" name="lName" required />

      <label for="address">Address:</label>
      <input type="text" id="address" name="address" required />

      <label for="phoneNumber">Phone Number:</label>
      <input type="tel" id="phoneNumber" name="phone" required />

      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required />

      <button type="submit">Update Profile</button>
    </form>
  </body>
</html>
