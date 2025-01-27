<%@ page import="java.util.List" %>
<%@ page import="com.example.StudentDAO" %>
<%@ page import="com.example.Student" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h1>List of Students</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Course</th>
            <th>Contact</th>
        </tr>
        <%
            StudentDAO studentDAO = new StudentDAO();
            List<Student> students = studentDAO.getAllStudents();
            for (Student student : students) {
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getAge() %></td>
            <td><%= student.getCourse() %></td>
            <td><%= student.getContact() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
