<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!Doctype>
<html>
<head>
    <%@include file="includes/header.jsp" %>
</head>
<body>
<div class="container">
    <jsp:include page="includes/header_page.jsp"/>
    <div class="contact-page main grid-wrap">
        <header class="grid col-full">
            <hr>
        </header>

        <aside class="grid col-one-quarter mq2-col-one-third mq3-col-full">
           <jsp:include page="includes/left_panel_executors.jsp"/>
        </aside>

        <section class="grid col-three-quarters mq2-col-two-thirds mq3-col-full">
            <h2>Create a new task:</h2>

            <p class="warning">Don't forget to put your own email address in the php file!</p>
            <form:form action="create_executor.html" modelAttribute="executor" id="contact_form" class="contact_form"
                       method="post">
                <ul>
                    <li>
                        <label for="name">Name of the executor</label>
                        <form:input path="name"/>
                    </li>
                    <li>
                        <label for="type">Type:</label>
                        <form:select path="type">
                            <c:forEach items="${types}" var="types">
                                <form:option value="${types}">${types}</form:option>
                            </c:forEach>
                        </form:select>
                    </li>
                    <li>
                        <label for="status">Status:</label>
                        <form:select path="status">
                            <c:forEach items="${statuses}" var="statuses">
                                <form:option value="${statuses}">${statuses}</form:option>
                            </c:forEach>
                        </form:select>
                    </li>
                    <li>
                        <button type="submit" name="submit">Create</button>
                    </li>
                </ul>
            </form:form>
        </section>
    </div>
</div>
</div>
</body>
</html>
