<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
<head>
    <%@include file="header.jsp" %>
</head>
<body>
<p><spring:message code="message.last.executors"/></p>
<c:forEach var="executors" items="${executors}">
    <figure class="grid col-one-full work_1">
        <figcaption>
            <hr>
            <br>

            <p><spring:message code="message.name"/> ${executors.name}</p>

            <p><spring:message code="message.type"/> ${executors.type}</p>

            <p><spring:message code="message.status"/> ${executors.status}</p>

            <p><a href=get_executor_info.html?name=${executors.name}><spring:message code="message.more.info"/></a></p>
            <br>
        </figcaption>
    </figure>
</c:forEach>
</body>
</html>

