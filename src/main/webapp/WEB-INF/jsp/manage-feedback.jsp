<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link rel="stylesheet" href="/css/manage-feedback.css" />
  </head>
  <body>
    <jsp:include page="components/header.jsp" />
    <main>
      <% for(int i = 0; i < 50; i++) { %>
      <div class="feedback">
        <p>This is a feedback.</p>
        <small class="date">2020-01-01</small>
      </div>
      <% } %>
    </main>
  </body>
</html>
