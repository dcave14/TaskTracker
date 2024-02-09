<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Task, model.TaskManager" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    TaskManager taskManager = (TaskManager) getServletContext().getAttribute("taskManager");
    if (taskManager == null) {
        taskManager = new TaskManager();
        getServletContext().setAttribute("taskManager", taskManager);
    }
    request.setAttribute("tasks", taskManager.getTasks());
%>
<html>
<head>
    <title>Task Tracker - Task List</title>
</head>
<body>
<h2>Task List</h2>
<c:if test="${not empty tasks}">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.id}</td>
                <td>${task.description}</td>
                <td>${task.completed ? "Completed" : "Pending"}</td>
                <td>
                    <c:if test="${not task.completed}">
                        <form action="completeTask" method="post">
                            <input type="hidden" name="id" value="${task.id}">
                            <button type="submit">Mark as Completed</button>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empty tasks}">
    <p>No tasks available.</p>
</c:if>
<a href="index.jsp"><button type="button">Back to Main Page</button></a>
</body>
</html>
