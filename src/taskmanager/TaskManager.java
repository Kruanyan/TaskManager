package taskmanager;

public class TaskManager {
    public static void main(String[] args) throws Exception {
        GUI app = new GUI();
        app.setVisible(true);
        Notification not = new Notification();
        not.notificationWin();
    }
}
