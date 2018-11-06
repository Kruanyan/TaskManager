package taskmanager;

import java.awt.*;
import java.awt.event.*;

public class Notification{
    public static void notificationWin() throws Exception {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();

            java.awt.Image image = Toolkit.getDefaultToolkit().getImage("images/tray.gif");
            TrayIcon trayIcon = new TrayIcon(image);
            tray.add(trayIcon);
            
            PopupMenu popup = new PopupMenu();
            MenuItem miExit = new MenuItem("Exit");
            ActionListener al = new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                System.exit(0);
              }
            };
            miExit.addActionListener(al);
            popup.add(miExit);
            
            trayIcon.setPopupMenu(popup);
            trayIcon.displayMessage("Название задачи", "Описание задачи",
                    TrayIcon.MessageType.INFO);
            
        }
    }
}