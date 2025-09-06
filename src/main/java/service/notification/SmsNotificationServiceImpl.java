package service.notification;

public class SmsNotificationServiceImpl implements  NotificationService{

    @Override
    public boolean send(String message, String recipient) {
        System.out.println("📱 SMS to " + recipient + ": " + message);
        return true;
    }
}
