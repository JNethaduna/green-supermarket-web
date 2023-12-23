<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link rel="stylesheet" href="/css/manage-product.css" />
  </head>
  <body>
    <jsp:include page="components/header.jsp" />
    <main>
      <form action="/manage/product/add" method="post">
        <input name="name" type="text" placeholder="Name" />
        <textarea name="description" placeholder="Description"></textarea>
        <input name="category" type="text" />
        <input name="price" type="number" />
        <button type="submit">Add Product</button>
      </form>
    </main>
  </body>
</html>
