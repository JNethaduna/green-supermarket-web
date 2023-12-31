<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <style>
      main {
        min-height: 100vh;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
      }

      h1 {
        font-size: 2rem;
        margin-bottom: 0.5rem;
      }

      p {
        margin-bottom: 0.5rem;
        margin-top: 1rem;
      }

      a {
        text-decoration: none;
        border-radius: 10px;
        padding: 0.5rem 1rem;
        background-color: var(--primary-color);
      }
    </style>
  </head>
  <body>
    <jsp:include page="components/header.jsp" />
    <main>
      Your feedback has been submitted successfully! Thank you!
      <p><a href="/">Go back to the home page</a></p>
    </main>
    <jsp:include page="components/footer.jsp" />
  </body>
</html>
