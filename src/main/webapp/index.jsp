<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Task Tracker</title>
</head>
<body>
	<h1>Task Tracker</h1>
    <h3>Add New Task</h3>
    <form action="addTask" method="post">
        <label for="description">Task Description:</label>
        <input type="text" id="description" name="description" required>
        <button type="submit">Add Task</button>
    </form>
    <br>
    <h3>View Current Tasks</h3>
    <a href="tasks.jsp"><button type="button">View Current Tasks</button></a>
</body>
</html>
