<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Your Green Supermarket</title>
  <style>
    body {
      font-family: 'Arial', sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
    }

    header, footer {
      background-color: #4CAF50; 
      color: white;
      text-align: left;
      padding: 20px;
    }

    main {
      padding: 20px;
      text-align: left; 
    }

    .footer-content {
      display: flex;
      flex-direction: row; 
      margin: 0 auto; 
    }

    .footer-section {
      width: 80%;
      margin-right: 20px; 
      margin-bottom: 20px;
      padding: 20px;
      border-radius: 8px;
      transition: transform 0.3s ease;
    }

    .footer-section:last-child {
      margin-right: 0; 
    }

    .footer-section:hover {
      transform: translateY(-5px);
    }

    h3 {
      color: white; 
    }

    ul {
      list-style-type: none;
      padding: 0;
    }

    ul li {
      margin-bottom: 10px;
    }

    a {
      text-decoration: none;
      color: white; 
      font-weight: bold;
      transition: color 0.3s ease;
    }

    a:hover {
      color: white; 
    }

    .footer-bottom {
      margin-top: 20px;
      text-align: center;
    }

    .social-icons {
      margin-top: 10px;
      display: flex;
      justify-content: center;
    }

    .social-icons a {
      margin: 0 10px;
      font-size: 20px;
      color: white; 
      transition: color 0.3s ease;
    }

    .social-icons a:hover {
      color: white; 
    }

    .footer-description {
      font-size: 14px;
      color: white;
      text-align: center;
    }
  </style>
</head>
<body>
  <footer>
    <div class="footer-content">
      <div class="footer-section">
        <h3>The GREEN Supermarket</h3>
        <p>We are a leading supermarket in the supermarket industry and we are dedicated to providing sustainable and eco-friendly products. Our mission is to create a greener future for our community and beyond.</p>
      </div>  
      <div class="footer-section">
        <h3>Quick Links</h3>
        <ul>
          <li><a href="#" target="_blank">Home</a></li>
          <li><a href="#" target="_blank">Cart</a></li>
          <li><a href="#" target="_blank">Contact Us</a></li>
        </ul>
      </div>
      <div class="footer-section">
        <h3>Developers</h3>
        <p>Group B10
        <br>Software Engineering 02 Module
        <br>22.1 Batch
        <br>NSBM Green University</p>
      </div>
    </div>
    <p class="footer-description">&copy; 2023 The Green Supermarket. All Rights Reserved.</p>
  </footer>
</body>
</html>
