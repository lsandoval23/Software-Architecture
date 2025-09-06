package service.notification;

public interface NotificationService {
    boolean send(String message, String recipient);
}
