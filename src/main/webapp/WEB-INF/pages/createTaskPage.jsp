<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!Doctype>
<html>
<head>
    <%@include file="includes/header.jsp" %>
</head>
<body>
<div class="container">
    <jsp:include page="includes/headerPage.jsp"/>
    <div class="contact-page main grid-wrap">
        <header class="grid col-full">
            <hr>
        </header>
        <aside class="grid col-one-quarter mq2-col-one-third mq3-col-full">
            <jsp:include page="includes/leftPanelTasks.jsp"/>
        </aside>
        <section class="grid col-three-quarters mq2-col-two-thirds mq3-col-full">
            <h2><spring:message code="message.create.new.task"/> </h2>

            <p class="warning">${message}</p>
            <form:form action="create_task.html" id="contact_form" class="contact_form" modelAttribute="task"
                       method="post">
                <ul>
                    <li>
                        <label for="name"><spring:message code="message.name.task"/></label>
                        <form:input path="name"/>
                    </li>
                    <li>
                        <label for="executor"><spring:message code="message.select.executor"/></label>
                        <form:select path="executor">
                            <c:forEach var="executors" items="${executors}">
                                <form:option value="${executors.name}">${executors.name}</form:option>
                            </c:forEach>
                        </form:select>
                    </li>
                    <li>
                        <label for="priority"><spring:message code="message.priority"/></label>
                        <form:select path="priority">
                            <c:forEach varStatus="loop" begin="1" end="10">
                                <form:option value="${loop.index}">${loop.index}</form:option>
                            </c:forEach>
                        </form:select>
                    </li>
                    <li>
                        <label for="type"><spring:message code="message.type"/></label>
                        <form:select path="type">
                            <c:forEach items="${types}" var="types">
                                <form:option value="${types}">${types}</form:option>
                            </c:forEach>
                        </form:select>
                    </li>
                    <li>
                        <label for="status"><spring:message code="message.status"/></label>
                        <form:select path="status">
                            <c:forEach items="${statuses}" var="statuses">
                                <form:option value="${statuses}">${statuses}</form:option>
                            </c:forEach>
                        </form:select>
                    </li>
                    <li>
                        <button type="submit" name="submit"><spring:message code="message.create.low"/></button>
                    </li>
                </ul>
            </form:form>
        </section>
    </div>
</div>
</div>
</body>
</html>
