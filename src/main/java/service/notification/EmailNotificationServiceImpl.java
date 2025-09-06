package service.notification;

public class EmailNotificationServiceImpl implements NotificationService{

    @Override
    public boolean send(String message, String recipient) {
        System.out.println("📧 Email to " + recipient + ": " + message);
        return true;
    }
}
