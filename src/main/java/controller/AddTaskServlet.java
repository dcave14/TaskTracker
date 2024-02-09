/* Dakota Cave
Java II
2/6/24 */

package controller;

import model.TaskManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        TaskManager taskManager = (TaskManager) context.getAttribute("taskManager");
        if (taskManager == null) {
            taskManager = new TaskManager();
            context.setAttribute("taskManager", taskManager);
        }
        String description = request.getParameter("description");
        taskManager.addTask(description);
        response.sendRedirect("tasks.jsp");
    }
}
