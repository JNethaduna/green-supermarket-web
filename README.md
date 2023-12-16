# green-supermarket-web

Website for Green Supermarket - SE2 - PUSL2024

## Request Paths

### General

- GET - `/` - Home page
- GET - `/login` - Login page
- GET - `/register` - Register page

### Product

- GET - `/product/{id}` - Product page
- GET - `/product/list?category={category}&page={page}&size={size}` - Products page filtered by category if any
- POST - `/product/add` - Add product
- PUT - `/product/update` - Update product
- DELETE - `/product/delete` - Delete product
- GET - `/manage/product` - Admin page for managing products

### Cart

- GET - `/cart` - Cart page
- POST - `/cart/add` - Add product to cart
- PUT - `/cart/update` - Update product quantity in cart (AJAX maybe)
- DELETE - `/cart/remove` - Remove product from cart (AJAX maybe)

### Order

- GET - `/user/order/{id}` - Order page
- GET - `/user/order/list` - Orders page
- GET - `/user/order/list?status={status}` - Orders page filtered by status
- GET - `/checkout` - Checkout page
- POST - `/order/create` - Checkout
- PUT - `/user/order/cancel` - Cancel order
- GET - `/manage/orders` - Admin page for managing orders
- PUT - `/order/update` - Update order status for managers

### Feedback

- GET - `/feedback` - Feedback page
- POST - `/feedback/submit` - Send feedback
- GET - `/manage/feedback` - Admin page for reviewing feedback

### Customer

- GET - `/user/profile` - User Profile page
- POST - `/user/profile/update` - Update user profile
- POST - `/login` - Login
- POST - `/register` - Register
- POST - `/logout` - Logout
