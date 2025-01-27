import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        
        // Prompt for login
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        if (userDAO.authenticate(username, password)) {
            System.out.println("Login successful!");

            StudentDAO studentDAO = new StudentDAO();

            // Take input for new student details
            System.out.println("\nEnter new student details:");

            System.out.print("Enter student name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter student age: ");
            int age;
            while (true) {
                try {
                    age = Integer.parseInt(scanner.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a valid age: ");
                }
            }

            System.out.print("Enter student course: ");
            String course = scanner.nextLine().trim();

            System.out.print("Enter student contact number: ");
            String contact = scanner.nextLine().trim();

            // Add student to the database
            Student student = new Student(0, name, age, course, contact);
            studentDAO.addStudent(student);

            // Display all students from the database
            System.out.println("\nList of Students:");
            studentDAO.getAllStudents().forEach(stud -> 
                System.out.println("ID: " + stud.getId() + 
                                   ", Name: " + stud.getName() + 
                                   ", Age: " + stud.getAge() + 
                                   ", Course: " + stud.getCourse() + 
                                   ", Contact: " + stud.getContact()));

        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
        
        scanner.close();
    }
}
