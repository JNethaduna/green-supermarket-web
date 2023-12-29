<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link rel="stylesheet" href="/css/feedback.css" />
  </head>
  <body>
    <jsp:include page="components/header.jsp" />
    <main>
      <form action="/user/feedback/submit">
        <h1>Feedback</h1>
        <textarea
          name="feedback"
          placeholder="We are always looking for ways to improve our service. If you have any feedback, please let us know."></textarea>
        <button type="submit">Submit</button>
      </form>
    </main>
    <jsp:include page="components/footer.jsp" />
  </body>
</html>
