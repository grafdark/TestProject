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
            <p class="fleft">Executors</p>
        </header>
    </div>
    <aside class="grid col-one-quarter mq2-col-full">
        <p>Sorting</p>
        <menu>
            <a href="executors_sort_by_type.html?type=READER">Only reader</a>
            <br>
            <a href="executors_sort_by_type.html?type=WRITER">Only writer</a>
            <br>
            <a href="executors_sort_by_alphabet.html">By name</a>
            <br>
        </menu>
    </aside>
    <div class="grid col-three-quarters mq2-col-full">
        <div class="grid-wrap works">
            <c:forEach var="executors" items="${executors}">
                <figure class="grid col-one-third mq1-col-one-half mq2-col-one-third mq3-col-full work_1">
                    <figcaption>
                        <a href="edit_executor_page.html?name=${executors.name}" class="arrow">Edit</a>
                        <a href="delete_executor.html?name=${executors.name}" class="arrow" onclick="return deleteExecutor()">Delete</a>
                        <p>Name: ${executors.name}</p>

                        <p>Type: ${executors.type}</p>

                        <p>Status: ${executors.status}</p>

                        <p> <a href=get_executor_info.html?name=${executors.name}> More info</a></p>

                    </figcaption>
                </figure>
            </c:forEach>
        </div>
        </section>
    </div>
</div>
</body>
</html>
