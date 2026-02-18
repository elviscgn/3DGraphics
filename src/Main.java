import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("3D Graphics Render");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        DrawingPanel panel = new DrawingPanel();
        frame.add(panel);

        frame.setVisible(true);

        panel.clearScreen();

        double[][] vertices = {
                {0.5, 0.5, 0.5},
                {-0.5, 0.5, 0.5},
                {0.5, -0.5, 0.5},
                {-0.5, -0.5, 0.5},

                {0.5, 0.5, -0.5},
                {-0.5, 0.5, -0.5},
                {0.5, -0.5, -0.5},
                {-0.5, -0.5, -0.5}
        };

//        CustomPoint coord1 = this.project(0.5, 0.5, 1 + dz);
//        CustomPoint coord2 = this.project(-0.5, 0.5, 1 + dz);
//        CustomPoint coord3 = this.project(0.5, -0.5, 1 + dz);
//        CustomPoint coord4 = this.project(-0.5, -0.5, 1 + dz);

        while (true) {
            try {
                panel.updateFrame(vertices);
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted while sleeping");
            }
        }
    }



}