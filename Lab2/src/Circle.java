import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle {
    protected static final int SIZE = 20;
    protected double x = 0;
    protected double y = 0;
    private double dx = 1;
    private double dy = 1;

    public Color getColor() {
        return color;
    }

    protected Color color;

    public Circle(double x, double y, double d, int color) {
        this.x = x;
        this.y = y;
        this.dx = d;
        this.dy = d;
        this.color = Utils.getColor(color);
    }

    public void move(Rectangle bounds) {
        x += dx;
        y += dy;
        if (x < bounds.getMinX()){
            x = bounds.getMinX() ;
            dx = -dx;
            color = Utils.getColor(Utils.getRandomNumber(0, 8));
        }
        if (x + SIZE >= bounds.getMaxX()){
            x = bounds.getMaxX() - SIZE;
            dx = -dx;
            color = Utils.getColor(Utils.getRandomNumber(0, 8));
        }
        if (y < bounds.getMinY()){
            y = bounds.getMinY() ;
            dy = -dy;
            color = Utils.getColor(Utils.getRandomNumber(0, 8));
        }
        if (y + SIZE >= bounds.getMaxY()){
            y = bounds.getMaxY() - SIZE;
            dy = -dy;
            color = Utils.getColor(Utils.getRandomNumber(0, 8));
        }
    }

    /*
     *Получает форму окружности в данной позиций.
     */
    public Ellipse2D getShape (){
        return new Ellipse2D.Double(x, y, SIZE, SIZE);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return SIZE;
    }

    public void turn(double nx, double ny) {
        dx = -dx;
        dy = -dy;
    }
}
