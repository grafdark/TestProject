<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
<head>
  <%@include file="header.jsp" %>
</head>
<body>
  <p><spring:message code="message.last.tasks"/> </p>
  <c:forEach var="tasks" items="${tasks}">
    <figure class="grid col-one-full work_1">
      <figcaption>
        <hr>
        <br>

        <p><spring:message code="message.name.task"/> ${tasks.name}</p>

        <p><spring:message code="message.date"/> ${tasks.date}</p>

        <p><spring:message code="message.status"/>  ${tasks.status}</p>

        <p><spring:message code="message.type"/>  ${tasks.type}</p>

        <p><spring:message code="message.priority"/>  ${tasks.priority}</p>

        <p><spring:message code="message.executor"/> : <a href="get_executor_info.html?name=${tasks.executor}"> ${tasks.executor}</a></p>
        <br>
      </figcaption>
    </figure>
  </c:forEach>
</body>
</html>
