<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
<head>
  <%@include file="header.jsp" %>
</head>
<body>
<p>5 last executors</p>
<c:forEach var="executors" items="${executors}">
  <figure class="grid col-one-full work_1">
    <figcaption>
      <hr>
      <br>
      <p>Name: ${executors.name}</p>
      <p>Type: ${executors.type}</p>
      <p>Status: ${executors.status}</p>
      <p><a href=get_executor_info.html?name=${executors.name}> More info</a></p>
      <br>
    </figcaption>
  </figure>
</c:forEach>
</body>
</html>

