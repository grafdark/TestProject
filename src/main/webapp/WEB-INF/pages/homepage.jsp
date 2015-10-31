<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="includes/header.jsp"%>
    <script type="text/javascript">
        function deleteTask() {
            if (confirm("Are you sure you want to delete task?"))
                return true;
            else
                return false;
        }
    </script>
</head>
<body>
<div class="container">
<jsp:include page="includes/header_page.jsp" />
    <div class="works-page main grid-wrap">
        <header class="grid col-full">
            <hr>
            <p class="fleft">Tasks</p>
        </header>
    </div>
    <jsp:include page="includes/panel_sorting_tasks.jsp"/>
    <section class="grid col-three-quarters mq2-col-full">
        <div class="grid-wrap works">
            <c:forEach var="tasks" items="${tasks}">
                <figure class="grid col-one-third mq1-col-one-half mq2-col-one-third mq3-col-full work_1">
                    <figcaption>
                        <a href="perform.html" class="arrow">Perform!</a>

                        <p>Name of the task: ${tasks.name}</p>

                        <p>Date: ${tasks.date}</p>

                        <p>Status: ${tasks.status}</p>

                        <p>Type: ${tasks.type}</p>

                        <p>Priority: ${tasks.priority}</p>

                        <p>Executor: <a href="get_executor_info.html?name=${tasks.executor}"> ${tasks.executor}</a></p>
                        <a href="edit_task_page.html?id=${tasks.id}" class="arrow">Edit</a>
                        <a href="deleteTask.html?id=${tasks.id}" class="arrow" onclick="return deleteTask()">Delete</a>
                    </figcaption>
                </figure>
            </c:forEach>
        </div>
    </section>
</div>
</body>
</html>
