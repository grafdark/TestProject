<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="includes/header.jsp" %>
<script type="text/javascript">
    function deleteExecutor() {
        if (confirm("Are you sure you want to delete task?")) {
            return true;
        }
        else {
            return false;
        }
    }
</script>
<body>
<div class="container">
    <jsp:include page="includes/headerPage.jsp"/>
    <div class="works-page main grid-wrap">
        <header class="grid col-full">
            <hr>
        </header>
    </div>
    <aside class="grid col-one-quarter mq2-col-full">
        .
    </aside>
    <div class="grid col-three-quarters mq2-col-full">
        <div class="grid-wrap works">
            <h2><spring:message code="message.info.executor"/></h2>
            <p style="color: red">${message}</p>
            <figure class="warning">
                <figcaption>

                    <p><spring:message code="message.name"/> ${executor.name}</p>

                    <p><spring:message code="message.type"/> ${executor.type}</p>

                    <p><spring:message code="message.status"/> ${executor.status}</p>

                    <a href="edit_executor_page.html?name=${executor.name}" class="arrow"><spring:message
                            code="message.edit"/></a>
                    <a href="delete_executor.html?name=${executor.name}" class="arrow"
                       onclick="return deleteExecutor()"><spring:message code="message.delete"/></a>
                </figcaption>
            </figure>
            <p><spring:message code="message.tasks"/></p>
            <c:choose>
                <c:when test="${not empty executor.tasks}">
                    <c:forEach var="tasks" items="${executor.tasks}">
                        <figure class="grid col-one-third mq1-col-one-half mq2-col-one-third mq3-col-full work_1">
                            <figcaption>
                                <c:choose>
                                    <c:when test="${tasks.status eq 'NOT_STARTED'}"><a
                                            href="perform.html?taskName=${tasks.name}&executor=${tasks.executor}&type=${tasks.type}&id=${tasks.id}"
                                            class="arrow"><spring:message code="message.perform"/></a></c:when>
                                    <c:when test="${tasks.status eq 'LOCK'}">
                                        <a href="#"><spring:message code="message.task.locked"/></a>
                                    </c:when>
                                    <c:when test="${tasks.status eq 'COMPLETED'}">
                                        <a href="#"> <spring:message code="message.task.completed"/></a>
                                    </c:when>
                                </c:choose>

                                <p><spring:message code="message.name.task"/> ${tasks.name}</p>

                                <p><spring:message code="message.date"/> ${tasks.date}</p>

                                <p><spring:message code="message.status"/> ${tasks.status}</p>

                                <p><spring:message code="message.type"/> ${tasks.type}</p>

                                <p><spring:message code="message.priority"/> ${tasks.priority}</p>

                                <a href="edit_task_page.html?id=${tasks.id}" class="arrow"><spring:message
                                        code="message.edit"/></a>
                                <a href="deleteTask.html?id=${tasks.id}" class="arrow"
                                   onclick="return deleteTask()"><spring:message code="message.delete"/></a>
                            </figcaption>
                        </figure>
                    </c:forEach>
                </c:when>
                <c:when test="${empty executor.tasks}">
                    <p><spring:message code="message.no.tasks"/></p>
                </c:when>
            </c:choose>
        </div>
        </section>
    </div>
</div>
</body>
</html>
