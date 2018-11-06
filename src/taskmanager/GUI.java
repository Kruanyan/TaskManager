package taskmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    private JPanel panel = new JPanel(new GridLayout(1,2,2,2));
    
    public GUI() {
        super("Task Manager");
        
        setBounds(510, 200, 200, 200);
        setSize(400,100);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        Container container = getContentPane();
        panel.setDoubleBuffered(false);
        container.add(panel);
        repaintField();
    }
    
    public void repaintField() {
        panel.removeAll();
        JButton button = new JButton("Добавить задачу");
        button.setFocusable(false);
        ActionListener actionListener = new AddEventListener();
        button.addActionListener(actionListener);
        panel.add(button);
        JButton button2 = new JButton("Удалить задачу");
        button2.setFocusable(false);
        ActionListener actionListener2 = new DeleteEventListener();
        button.addActionListener(actionListener2);
        panel.add(button2);
        panel.validate();
        panel.repaint();
    }
    public class AddEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    public class DeleteEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        
        }
    }
}
