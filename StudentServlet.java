import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get data from HTML form
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String course = request.getParameter("course");
        String contact = request.getParameter("contact");

        // Create Student object and save it using DAO
        StudentDAO studentDAO = new StudentDAO();
        Student student = new Student(0, name, age, course, contact);
        studentDAO.addStudent(student);

        // Redirect to student list page
        response.sendRedirect("listStudents.jsp");
    }
}
