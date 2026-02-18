import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("2D Graphics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        DrawingPanel panel = new DrawingPanel();
        frame.add(panel);

        frame.setVisible(true);

        panel.clearScreen();
        panel.drawPoint(0, -5);
//        panel.point(200, 200);
//        panel.point(300, 100);

    }
}