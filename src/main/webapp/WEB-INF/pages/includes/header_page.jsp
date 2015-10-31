<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
<head>
    <%@include file="header.jsp"%>
</head>
<body>
<header id="navtop">
    <a href="homepage.html" class="logo left"><img src="../img/logo.png" alt="Task and Executors"></a>
    <nav class="fright">
        <ul>
            <li>
                <a href="homepage.html"><spring:message code="message.homepage" text="Home"/></a>
            </li>
        </ul>
        <ul>
            <li>
                <spring:message code="message.get" text="GET"/>
            </li>
            <li>
                <a href="get_executors.html"><spring:message code="message.executors" text="Executors"/></a>
            </li>
            <li>
                <a href="get_tasks.html"><spring:message code="message.tasks" text="Tasks"/> </a>
            </li>
        </ul>
        <ul>
            <li>
                CREATE
            </li>
            <li>
                <a href="create_executor_page.html">Executor</a>
            </li>
            <li>
                <a href="create_task_page.html">Task</a>
            </li>
        </ul>
    </nav>
</header>
</body>
</html>
