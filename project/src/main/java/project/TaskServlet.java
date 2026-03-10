package project;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < TaskStorage.tasks.size(); i++) {

            Task t = TaskStorage.tasks.get(i);

            json.append("{")
                    .append("\"id\":").append(t.getId()).append(",")
                    .append("\"title\":\"").append(t.getTitle()).append("\",")
                    .append("\"priority\":\"").append(t.getPriority()).append("\",")
                    .append("\"completed\":").append(t.isCompleted())
                    .append("}");

            if (i != TaskStorage.tasks.size() - 1)
                json.append(",");
        }

        json.append("]");

        out.print(json.toString());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String priority = request.getParameter("priority");

        Task task = new Task(TaskStorage.idCounter++, title, priority, false);

        TaskStorage.tasks.add(task);

        response.getWriter().print("Task Added");
    }


    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        TaskStorage.tasks.removeIf(task -> task.getId() == id);

        response.getWriter().print("Task Deleted");
    }


    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        for (Task task : TaskStorage.tasks) {
            if (task.getId() == id) {
                task.setCompleted(!task.isCompleted());
            }
        }

        response.getWriter().print("Task Updated");
    }
    protected void doPatch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String priority = request.getParameter("priority");

        for(Task task : TaskStorage.tasks){

            if(task.getId() == id){

                task.setTitle(title);

            }

        }

        response.getWriter().print("Task Updated");

    }
}