package app;

import model.Book;
import model.Loan;
import model.User;
import service.fine.FineCalculator;
import service.notification.NotificationService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LoanManager {

    private final FineCalculator fineCalculator;
    private final NotificationService notifier;

    public LoanManager(FineCalculator fineCalculator, NotificationService notifier) {
        this.fineCalculator = fineCalculator;
        this.notifier = notifier;
    }

    public Loan makeLoan(Book book, User user) {
        if (!book.isAvailable()) {
            System.out.println("❌ The book '" + book.getTitle() + "' is not available");
            return null;
        }

        book.setAvailable(false);
        Loan loan = new Loan(book, user);

        String message = "You borrowed '" + book.getTitle() + "'. Due date: "
                + loan.getDueDate().toLocalDate();
        notifier.send(message, user.getName());

        System.out.println("✅ Loan created: '" + book.getTitle() + "' for " + user.getName());
        return loan;
    }

    public void returnBook(Loan loan) {
        if (loan.isReturned()) {
            System.out.println("❌ This book was already returned");
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(loan.getDueDate())) {
            long delayDays = ChronoUnit.DAYS.between(loan.getDueDate(), now);
            double fine = fineCalculator.calculate(delayDays);
            System.out.println("⚠️  Delay of " + delayDays + " days. Fine: $" + fine);
        } else {
            System.out.println("✅ Book returned on time");
        }

        loan.setReturned(true);
        loan.getBook().setAvailable(true);
        System.out.println("📚 '" + loan.getBook().getTitle() + "' returned by " + loan.getUser().getName());
    }
}
