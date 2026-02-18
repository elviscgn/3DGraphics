import java.awt.*;

public class CustomPoint {
    int x,y, size;
    Color color;

    public CustomPoint(int x, int y, int size) {
//        80, 255, 80
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = new Color(80, 255, 80);
    }

    public void toScreenCoord() {
        this.x = (int)(((double)this.x + 1) / 2 * 800);
        this.y = (int)((1.0 - (double)(this.y + 1) / 2.0) * 500);
    }
}
