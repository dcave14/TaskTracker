package controller;

import model.TaskManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/completeTask")
public class CompleteTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        TaskManager taskManager = (TaskManager) context.getAttribute("taskManager");
        int id = Integer.parseInt(request.getParameter("id"));
        if (taskManager != null) {
            taskManager.completeTask(id);
        }
        response.sendRedirect("tasks.jsp");
    }
}
