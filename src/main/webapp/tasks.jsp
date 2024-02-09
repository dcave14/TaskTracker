<!--
This JSP file displays a list of tasks using JSTL (JavaServer Pages Standard Tag Library).
It imports the Task and TaskManager classes from the model package.
The tasks are retrieved from the TaskManager object stored in the servlet context.
If the TaskManager object is not found in the servlet context, a new one is created and stored.
The tasks are then set as a request attribute for rendering in the JSP.

The HTML structure of the page includes a table to display the task list.
Each task is rendered as a row in the table, showing the task ID, description, status, and an action button.
If a task is not completed, a form is displayed to allow marking it as completed.
If there are no tasks available, a message is displayed.

At the end of the page, there is a button to go back to the main page.
-->
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
