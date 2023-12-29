<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
  </head>
  <body>
    <form action="/manage/create/manager" method="post">
      <label>
        Email
        <input name="email" type="email" />
      </label>
      <label>
        Password
        <input name="password" type="password" />
      </label>
      <button type="submit">Submit</button>
    </form>
  </body>
</html>
