# green-supermarket-web

Website for Green Supermarket - SE2 - PUSL2024

## Request Paths

### General

- GET - `/` - Home page
- GET - `/login` - Login page
- GET - `/register` - Register page
- POST - `/login` - Login
- POST - `/logout` - Logout
- POST - `/register` - Register

### Product

- GET - `/product/{id}` - Product page
- GET - `/product/list?category={category}&page={page}&size={size}` - Products page filtered by category if any
- POST - `/manage/product/add` - Add product
- POST - `/manage/product/update` - Update product
- POST - `/manage/product/delete` - Delete product
- GET - `/manage/product/list?category={category}&page={page}&size={size}` - Admin page for managing products
- GET - `/manage/product/{id}` - Admin page for updating a product

### Cart

- GET - `/user/cart` - Cart page
- POST - `/user/cart/add` - Add product to cart
- POST - `/user/cart/update` - Update product quantity in cart (AJAX maybe)
- POST - `/user/cart/remove` - Remove product from cart (AJAX maybe)

### Order

- GET - `/user/order/{id}` - Order page
- GET - `/user/order/list` - Orders page
- GET - `/user/order/list?status={status}` - Orders page filtered by status
- GET - `/user/checkout` - Checkout page
- POST - `/user/order/create` - Checkout
- POST - `/user/order/cancel` - Cancel order
- GET - `/manage/order/{id}` - Admin page for managing orders
- POST - `/manage/order/{id}/update` - Update order status for managers

### Feedback

- GET - `/user/feedback` - Feedback page
- POST - `/user/feedback/submit` - Send feedback
- GET - `/manage/feedback` - Admin page for reviewing feedback

### Customer

- GET - `/user/profile` - User Profile page
- POST - `/user/profile/update` - Update user profile
