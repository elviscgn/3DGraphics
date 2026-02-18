import java.awt.*;

public class CustomPoint {
    double x,y, size;
    Color color;

    public CustomPoint(double x, double y, double size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = new Color(80, 255, 80);
    }

    public void toScreenCord() {
        this.x = (this.x + 1) / 2 * 800;
        this.y = (1.0 - (this.y + 1) / 2.0) * 500;
    }
}
