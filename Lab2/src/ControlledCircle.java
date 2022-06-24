import java.awt.*;

public class ControlledCircle extends Circle{

    public ControlledCircle(double x, double y, double d, int color) {
        super(x, y, d, color);
    }

    public void move(Rectangle bounds) {
        if (x < bounds.getMinX()){
            color = Utils.getColor(Utils.getRandomNumber(0, 8));
        }
        if (x + SIZE >= bounds.getMaxX()){
            color = Utils.getColor(Utils.getRandomNumber(0, 8));
        }
        if (y < bounds.getMinY()){
            color = Utils.getColor(Utils.getRandomNumber(0, 8));
        }
        if (y + SIZE >= bounds.getMaxY()){
            color = Utils.getColor(Utils.getRandomNumber(0, 8));
        }
    }

    public void turn(double nx, double ny) {

    }

    public void setPos(double nx, double ny) {
        x = nx - SIZE / 2.0;
        y = ny - SIZE * 1.8;
    }

    public void setButtonPos(double nx, double ny) {
        x = nx;
        y = ny;
    }
}
