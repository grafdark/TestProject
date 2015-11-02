<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
<head>
  <%@include file="header.jsp" %></head>
<body>
<aside class="grid col-one-quarter mq2-col-full">
  <p><spring:message code="message.sorting"/></p>
  <menu>
    <a href="find_by_type.html?type=READING"><spring:message code="message.only.reading"/></a>
    <br>
    <a href="find_by_type.html?type=WRITING"><spring:message code="message.only.writing"/></a>
    <br>
    <a href="find_not_started.html"><spring:message code="message.not.started"/></a>
    <br>
    <a href="sort_by_alphabet.html"><spring:message code="message.by.name"/></a>
    <br>
    <a href="sort_by_priority.html"><spring:message code="message.by.priority"/></a>
    <br>
    <a href="sort_by_date.html"><spring:message code="message.by.date"/></a>
  </menu>
</aside>
</body>
</html>
