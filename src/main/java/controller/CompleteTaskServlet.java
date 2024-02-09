/* Dakota Cave
Java II
2/6/24 */

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
        //get servlet context
        ServletContext context = getServletContext();
        
        //get task manager from servlet context
        TaskManager taskManager = (TaskManager) context.getAttribute("taskManager");
        
        //get task ID from request parameter
        int id = Integer.parseInt(request.getParameter("id"));
        
        //if task manager is not null, complete task with given ID
        if (taskManager != null) {
            taskManager.completeTask(id);
        }
        
        //redirect to tasks.jsp page
        response.sendRedirect("tasks.jsp");
    }
}
