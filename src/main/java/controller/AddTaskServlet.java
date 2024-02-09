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
        //get servlet context
        ServletContext context = getServletContext();
        
        //get task manager from servlet context
        TaskManager taskManager = (TaskManager) context.getAttribute("taskManager");
        
        //if task manager is null, create a new instance and set it in servlet context
        if (taskManager == null) {
            taskManager = new TaskManager();
            context.setAttribute("taskManager", taskManager);
        }
        
        //get task description from request parameter
        String description = request.getParameter("description");
        
        //add task to task manager
        taskManager.addTask(description);
        
        //redirect to tasks.jsp page
        response.sendRedirect("tasks.jsp");
    }
}
