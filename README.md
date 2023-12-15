# green-supermarket-web

Website for Green Supermarket - SE2 - PUSL2024

## Request Paths

GET

- `/` - Home page
- `/login` - Login page
- `/register` - Register page
- `/product/{id}` - Product page
- `/product/list?category={category}` - Products page filtered by category
- `/cart` - Cart page
- `/checkout` - Checkout page
- `/feedback` - Feedback page
- `/user/profile` - User Profile page
- `/user/order/{id}` - Order page
- `/user/order/list` - Orders page
- `/user/order/list?status={status}` - Orders page filtered by status
- `/manage/product` - Admin page for managing products
- `/manage/category` - Admin page for managing a product
- `/manage/order` - Admin page for managing orders
- `/manage/feedback` - Admin page for managing feedbacks

POST

- `/login` - Login
- `/register` - Register
- `/cart/add` - Add product to cart
- `/order/create` - Checkout
- `/feedback/submit` - Send feedback
- `/user/profile/update` - Update user profile
- `/user/order/cancel` - Cancel order
- `/product/add` - Add product
- `/category/add` - Add category

PUT

- `/product/update` - Update product
- `/category/update` - Update category
- `/order/update` - Update order
- `/cart/update` - Update product quantity in cart (AJUSSY also I cry)

DELETE

- `/product/delete` - Delete product
- `/category/delete` - Delete category
- `/cart/remove` - Remove product from cart (AJUSSY)
