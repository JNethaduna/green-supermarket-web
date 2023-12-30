<%@ taglib prefix="c" uri="jakarta.tags.core" %> <%@ taglib prefix="fn"
uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <jsp:include page="components/meta.jsp" />
    <link rel="stylesheet" href="/css/feedback-list.css" />
  </head>
  <body>
    <jsp:include page="components/header-manager.jsp" />
    <main>
      <c:forEach items="${feedbacks}" var="feedback">
        <div class="feedback">
          <p>${feedback.feedback}</p>
          <small class="date">${feedback.date}</small>
        </div>
      </c:forEach>
    </main>
  </body>
</html>
