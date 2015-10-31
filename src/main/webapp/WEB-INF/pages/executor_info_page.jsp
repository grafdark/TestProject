<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="includes/header.jsp" %>
<script type="text/javascript">
    function deleteExecutor() {
        if (confirm("Are you sure you want to delete task?"))
            return true;
        else
            return false;
    }
</script>
<body>
<div class="container">
    <jsp:include page="includes/header_page.jsp"/>
    <div class="works-page main grid-wrap">
        <header class="grid col-full">
            <hr>
        </header>
    </div>
    <aside class="grid col-one-quarter mq2-col-full">
        j
    </aside>
    <div class="grid col-three-quarters mq2-col-full">
        <div class="grid-wrap works">
            <h2>Info about the executor:</h2>
            <figure class="warning">
                <figcaption>

                    <p>Name: ${executor.name}</p>

                    <p>Type: ${executor.type}</p>

                    <p>Status: ${executor.status}</p>

                    <a href="edit_executor_page.html?name=${executor.name}" class="arrow">Edit</a>
                    <a href="delete_executor.html?name=${executor.name}" class="arrow"
                       onclick="return deleteExecutor()">Delete</a>
                </figcaption>
            </figure>
            <p>Tasks</p>
            <c:choose>
                <c:when test="${not empty executor.tasks}">
                    <c:forEach var="tasks" items="${executor.tasks}">
                        <figure class="grid col-one-third mq1-col-one-half mq2-col-one-third mq3-col-full work_1">
                            <figcaption>
                                <a href="perform.html" class="arrow">Perform!</a>

                                <p>Name of the task: ${tasks.name}</p>

                                <p>Date: ${tasks.date}</p>

                                <p>Status: ${tasks.status}</p>

                                <p>Type: ${tasks.type}</p>

                                <p>Priority: ${tasks.priority}</p>

                                <a href="edit_task_page.html?id=${tasks.id}" class="arrow">Edit</a>
                                <a href="deleteTask.html?id=${tasks.id}" class="arrow"
                                   onclick="return deleteTask()">Delete</a>
                            </figcaption>
                        </figure>
                    </c:forEach>
                </c:when>
                <c:when test="${empty executor.tasks}">
                    <p>No tasks</p>
                </c:when>
            </c:choose>
        </div>
        </section>
    </div>
</div>
</body>
</html>
