<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
<head>
  <%@include file="header.jsp" %>
</head>
<body>
  <p>5 last tasks</p>
  <c:forEach var="tasks" items="${tasks}">
    <figure class="grid col-one-full work_1">
      <figcaption>
        <hr>
        <br>

        <p>Name of the task: ${tasks.name}</p>

        <p>Date: ${tasks.date}</p>

        <p>Status: ${tasks.status}</p>

        <p>Type: ${tasks.type}</p>

        <p>Priority: ${tasks.priority}</p>

        <p>Executor: <a href="get_executor_info.html?name=${tasks.executor}"> ${tasks.executor}</a></p>
        <br>
      </figcaption>
    </figure>
  </c:forEach>
</body>
</html>
