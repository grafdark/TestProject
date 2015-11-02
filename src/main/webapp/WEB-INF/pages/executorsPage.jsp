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
    <jsp:include page="includes/headerPage.jsp"/>
    <div class="works-page main grid-wrap">
        <header class="grid col-full">
            <hr>
            <p class="fleft"><spring:message code="message.executors"/></p>
        </header>
    </div>
    <aside class="grid col-one-quarter mq2-col-full">
        <p><spring:message code="message.sorting"/></p>
        <menu>
            <a href="executors_sort_by_type.html?type=READER"><spring:message code="message.only.reader"/></a>
            <br>
            <a href="executors_sort_by_type.html?type=WRITER"><spring:message code="message.only.writer"/></a>
            <br>
            <a href="executors_sort_by_alphabet.html"><spring:message code="message.by.name"/></a>
            <br>
        </menu>
    </aside>
    <div class="grid col-three-quarters mq2-col-full">
        <div class="grid-wrap works">
            <c:forEach var="executors" items="${executors}">
                <figure class="grid col-one-third mq1-col-one-half mq2-col-one-third mq3-col-full work_1">
                    <figcaption>
                        <a href="edit_executor_page.html?name=${executors.name}" class="arrow"><spring:message code="message.edit"/></a>
                        <a href="delete_executor.html?name=${executors.name}" class="arrow" onclick="return deleteExecutor()"><spring:message code="message.delete"/></a>
                        <p><spring:message code="message.name"/> ${executors.name}</p>

                        <p><spring:message code="message.type"/> ${executors.type}</p>

                        <p><spring:message code="message.status"/> ${executors.status}</p>

                        <p> <a href=get_executor_info.html?name=${executors.name}> <spring:message code="message.more.info"/></a></p>

                    </figcaption>
                </figure>
            </c:forEach>
        </div>
        </section>
    </div>
</div>
</body>
</html>
