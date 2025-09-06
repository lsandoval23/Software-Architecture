package app;

import model.Book;
import model.Loan;
import model.User;
import service.fine.StandardFineCalculator;
import service.fine.StudentFineCalculator;
import service.notification.EmailNotificationServiceImpl;
import service.notification.SmsNotificationServiceImpl;

import java.time.LocalDateTime;

public class MainSystem {

    public static void main(String[] args) {
        System.out.println("🏛️  LIBRARY SYSTEM - SOLID PRINCIPLES");
        System.out.println("=".repeat(50));

        // Create books
        Book book1 = new Book("1984", "George Orwell", "978-0-452-28423-4");
        Book book2 = new Book("One Hundred Years of Solitude", "Gabriel García Márquez", "978-84-376-0494-7");

        // Create users
        User user1 = new User("Ana García", "U001");
        User user2 = new User("Carlos López", "U002");

        // Loan manager for regular users
        System.out.println("\n📋 LOAN MANAGER FOR REGULAR USERS:");
        LoanManager regularManager = new LoanManager(new StandardFineCalculator(), new EmailNotificationServiceImpl());

        // Loan manager for students
        System.out.println("\n📋 LOAN MANAGER FOR STUDENTS:");
        LoanManager studentManager = new LoanManager(new StudentFineCalculator(), new SmsNotificationServiceImpl());

        // Perform loans
        System.out.println("\n🔄 PERFORMING LOANS:");
        Loan loan1 = regularManager.makeLoan(book1, user1);
        Loan loan2 = studentManager.makeLoan(book2, user2);

        // Simulate late return
        System.out.println("\n📅 SIMULATING LATE RETURN:");
        loan1.setDueDate(LocalDateTime.now().minusDays(3));
        regularManager.returnBook(loan1);

        // Return on time
        System.out.println("\n📅 RETURN ON TIME:");
        studentManager.returnBook(loan2);
    }
}
